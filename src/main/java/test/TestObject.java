package test;

import bean.AlbumInfo;
import com.alibaba.fastjson.JSON;

public class TestObject {

    public static void main(String[] args) {
        AlbumInfo albumInfo = new AlbumInfo();
        albumInfo.setAlbumName("123");
        albumInfo.setAlbumId(12312);
        albumInfo.setIsPaid(false);
        System.out.println(JSON.toJSONString(albumInfo));
        Object o = albumInfo;
        System.out.println(JSON.toJSONString(o));
        AlbumInfo newAlbum = (AlbumInfo) o;
        System.out.println(JSON.toJSONString(newAlbum));
    }
}
