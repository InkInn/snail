package patterns.decorator;

import com.alibaba.fastjson.JSON;

import java.util.HashSet;

public class StrongBehavior extends Decorator {

    public StrongBehavior(Swan swan) {
        super(swan);
    }

    @Override
    public void fly() {
        System.out.println("会飞行了");
    }

    public static void main(String[] args) {
        HashSet<Long> set = new HashSet<>();
        set.add(1l);
        System.out.println(JSON.toJSONString(set));
    }
}
