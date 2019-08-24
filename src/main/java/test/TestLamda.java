package test;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author rcli
 * Created on 2019-07-04.
 */
public class TestLamda {

    public static void main(String[] args) {
        AtomicInteger settingForbid = new AtomicInteger();
        int count = 0;
        List<Integer> list = Lists.newArrayList(1,2,3,4,5,6);
        list.forEach(i->{
            settingForbid.incrementAndGet();
        });
        System.out.println(settingForbid.get());
    }

}
