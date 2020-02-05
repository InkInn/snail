package test;

import com.alibaba.fastjson.JSON;

import java.util.PriorityQueue;

/**
 * @author rcli
 * Created on 2020/1/19.
 */
public class PriorityQueueTest {

    public static void main(String[] args) {
        test();
    }

    public static void test(){
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int i = 0; i < 1000; i++){
            heap.add(i);
            if(heap.size() > 10){
                heap.remove();
            }
        }
        System.out.println(JSON.toJSONString(heap));
    }

}
