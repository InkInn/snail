package spring;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;

/**
 * @author rcli
 * Created on 2019-06-18.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value="classpath:application-context.xml")
public class EsTest {

    @Test
    public void test(){
        Map<Integer,Long> map = new HashMap<>();
        map.put(1,null);
        map.put(1,1L);
        System.out.println(JSON.toJSONString(map));
    }
}
