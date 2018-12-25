package future;

import bean.AlbumInfo;
import bean.ResultInfo;
import bean.TrackInfo;
import bean.UserInfo;
import com.alibaba.fastjson.JSON;

import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Test {

    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        // 步骤1
        // ......

        // 步骤2.1
        CompletableFuture<TrackInfo> trackInfoFuture = getTrackInfo(11111L,"声音");
        CompletableFuture<AlbumInfo> albumInfoFuture = getAlbumInfo(22222L,"专辑");
        CompletableFuture<UserInfo> userInfoFuture = getUserInfo(33333L,"小明");

        CompletableFuture<ResultInfo> resultInfoFuture = trackInfoFuture.thenCombineAsync(albumInfoFuture,(trackInfo,albumInfo) -> {
            ResultInfo resultInfo = new ResultInfo();
            resultInfo.setAlbumInfo(albumInfo);
            resultInfo.setTrackInfo(trackInfo);
            return resultInfo;
        }).thenCombineAsync(userInfoFuture, (resultInfo,userInfo) -> {
            resultInfo.setUserInfo(userInfo);
            return resultInfo;
        });

        // 步骤2.2

        // 步骤2.3

        // 步骤3
        // ....
        ResultInfo resultInfo = resultInfoFuture.get(1000, TimeUnit.MILLISECONDS);
        System.out.println(JSON.toJSONString(resultInfo));
    }

    private static CompletableFuture<ResultInfo> getResultInfo(){
        return CompletableFuture.supplyAsync(()->{
            ResultInfo resultInfo = new ResultInfo();
            return resultInfo;
        });
    }

    private static CompletableFuture<TrackInfo> getTrackInfo(long trackId, String trackName){
        return CompletableFuture.supplyAsync(() -> {
            TrackInfo trackInfo = new TrackInfo();
            trackInfo.setTrackId(trackId);
            trackInfo.setTrackName(trackName);
            return trackInfo;
        });
    }

    private static CompletableFuture<UserInfo> getUserInfo(long userId, String userName){
        return CompletableFuture.supplyAsync(() ->{
            UserInfo userInfo = new UserInfo();
            userInfo.setUserId(userId);
            userInfo.setUserName(userName);
            return userInfo;
        });
    }

    private static CompletableFuture<AlbumInfo> getAlbumInfo(long albumId, String albumName){
        CompletableFuture<AlbumInfo> future =  CompletableFuture.supplyAsync(() ->{
            AlbumInfo albumInfo = new AlbumInfo();
            albumInfo.setAlbumId(albumId);
            albumInfo.setAlbumName(albumName);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return albumInfo;
        });
        return FutureUtils.within(future, Duration.ofMillis(100)).exceptionally(e -> {
            return null;
        });
    }
}
