package patterns.observer;

import com.alibaba.fastjson.JSON;

import java.util.Observable;
import java.util.Observer;

public class LiSi implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("开始观察");
        System.out.println("arg");
        System.out.println(JSON.toJSONString(o));
        System.out.println("结束观察");
    }
}
