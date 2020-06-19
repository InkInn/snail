package test;

import bean.AlbumInfo;
import com.alibaba.fastjson.JSON;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

/**
 * @author rcli
 * Created on 2020/3/24.
 */
public class StringTest {
    public static void main(String[] args) throws UnsupportedEncodingException {
        int i = 0;
        fun1(i);
        System.out.println("main " + i);
    }

    private static void fun1(int i) {
        System.out.println("fun1 " + i);
        i++;
    }

    private static void test1(byte[] msg) throws UnsupportedEncodingException {
        String str = new String(msg, StandardCharsets.UTF_8);
        JSON.parseObject(str, AlbumInfo.class);
    }
}
