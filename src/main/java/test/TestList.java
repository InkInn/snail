package test;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;

public class TestList {

    public static void main(String[] args) {
        List<Integer> lists = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Map<Integer, Integer> countMap = new ConcurrentHashMap<>();
        List<CompletableFuture> futures = new ArrayList<>();
        for (Integer list : lists) {
            CompletableFuture<Integer> future = count(list).thenApply(result -> {
                System.out.println(Thread.currentThread().getName());
                countMap.put(list, result);
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return result;
            });
            futures.add(future);
        }
        CompletableFuture<Void> combineFuture = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
        try {
            combineFuture.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            System.out.println(entry.getKey());
        }
        Map<Integer, Integer> resultMap = new HashMap<>(countMap);
        System.out.println(JSON.toJSONString(resultMap));

        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(JSON.toJSONString(resultMap));
        System.out.println(JSON.toJSONString(countMap));
    }

    public static void test(){

    }

    private static CompletableFuture<Integer> count(int id) {
        return CompletableFuture.supplyAsync(() -> id);
    }
}
