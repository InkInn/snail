package test;

import bean.AlbumInfo;
import com.google.common.collect.Maps;

import java.util.Map;
import java.util.Optional;

public class TestOptional {

    public static void main(String[] args) throws Exception{
//        AlbumInfo albumInfo = getAlbum();
//        Optional.of(albumInfo).ifPresent( a -> System.out.println(JSON.toJSONString(a)));
        Map<String,String> map = Maps.newHashMap();
        map.get(null);
//        System.out.println(JSON.toJSONString(testPresent()));
    }

    private static Optional<AlbumInfo> getOptionAlbum() {
        AlbumInfo albumInfo = new AlbumInfo();
        albumInfo.setIsPaid(false);
        return Optional.of(albumInfo);
    }

    private static AlbumInfo getAlbum(){
        AlbumInfo albumInfo = new AlbumInfo();
        albumInfo.setIsPaid(false);
        return null;
    }

    private static AlbumInfo testPresent(){
        AlbumInfo albumInfo = getAlbum();
        return Optional.ofNullable(albumInfo).orElseGet(() ->{
            AlbumInfo albumInfo1 = new AlbumInfo();
            albumInfo1.setIsPaid(true);
            return albumInfo1;
        });
    }
}
