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
        AlbumInfo albumInfo = new AlbumInfo();
        albumInfo.setIsPaid(true);
        albumInfo.setAlbumId(111l);
        albumInfo.setAlbumName("asd");
        test1(JSON.toJSONString(albumInfo).getBytes());

    }

    private static void test1(byte[] msg) throws UnsupportedEncodingException {
        String str = new String(msg, StandardCharsets.UTF_8);
        JSON.parseObject(str, AlbumInfo.class);
    }
}
