package future;

import bean.AlbumInfo;
import bean.ResultInfo;
import bean.TrackInfo;
import bean.UserInfo;

import java.time.Duration;
import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Test {

    public static void main(String[] args) throws InterruptedException, TimeoutException, ExecutionException {
//        // 步骤1
//        // ......
//
//        // 步骤2.1
//        ResultInfo resultInfo = new ResultInfo();
//        CompletableFuture<TrackInfo> trackInfoFuture = getTrackInfo(11111L, "声音",resultInfo);
//        CompletableFuture<AlbumInfo> albumInfoFuture = getAlbumInfo(22222L, "专辑",resultInfo);
//        CompletableFuture<UserInfo> userInfoFuture = getUserInfo(33333L, "小明",resultInfo);
////        CompletableFuture<ResultInfo> resultInfoFuture = trackInfoFuture.thenCombine(albumInfoFuture, (trackInfo, albumInfo) -> {
////            System.out.println("combine1 " + Thread.currentThread().getName());
////            ResultInfo resultInfo = new ResultInfo();
////            resultInfo.setAlbumInfo(albumInfo);
////            resultInfo.setTrackInfo(trackInfo);
////            return resultInfo;
////        }).thenCombineAsync(userInfoFuture, (resultInfo, userInfo) -> {
////            System.out.println("combine2 " + Thread.currentThread().getName());
////            resultInfo.setUserInfo(userInfo);
////            return resultInfo;
////        });
//        CompletableFuture.allOf(trackInfoFuture,albumInfoFuture,userInfoFuture).get(1000,TimeUnit.MILLISECONDS);
//
////        System.out.println(albumInfoFuture.join());
////        Thread.sleep(3000);
//
//        // 步骤2.2
//
//        // 步骤2.3
//
//        // 步骤3
//        // ....
////        ResultInfo resultInfo = resultInfoFuture.get(1000, TimeUnit.MILLISECONDS);
//        System.out.println(JSON.toJSONString(resultInfo));
        Arrays.asList(2,3).add(1);
    }

    private static CompletableFuture<ResultInfo> getResultInfo() {
        return CompletableFuture.supplyAsync(() -> {
            ResultInfo resultInfo = new ResultInfo();
            return resultInfo;
        });
    }

    private static CompletableFuture<TrackInfo> getTrackInfo(long trackId, String trackName,ResultInfo resultInfo) {
        return CompletableFuture.supplyAsync(() -> {
            TrackInfo trackInfo = new TrackInfo();
            trackInfo.setTrackId(trackId);
            trackInfo.setTrackName(trackName);
            resultInfo.setTrackInfo(trackInfo);
            return trackInfo;
        });
    }

    private static CompletableFuture<UserInfo> getUserInfo(long userId, String userName,ResultInfo resultInfo) {
        return CompletableFuture.supplyAsync(() -> {
            UserInfo userInfo = new UserInfo();
            userInfo.setUserId(userId);
            userInfo.setUserName(userName);
            resultInfo.setUserInfo(userInfo);
            return userInfo;
        });
    }

    private static CompletableFuture<AlbumInfo> getAlbumInfo(long albumId, String albumName,ResultInfo resultInfo) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                return CompletableFuture.supplyAsync(() -> {
                    AlbumInfo albumInfo = new AlbumInfo();
                    albumInfo.setAlbumId(albumId);
                    albumInfo.setAlbumName(albumName);
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    resultInfo.setAlbumInfo(albumInfo);
                    return albumInfo;
                }).get(1000, TimeUnit.MILLISECONDS);
            } catch (Exception e) {
//                e.printStackTrace();
            }
            return null;
        });
    }

    private static CompletableFuture<AlbumInfo> getAlbumInfo2(long albumId, String albumName) {
        CompletableFuture<AlbumInfo> future =  CompletableFuture.supplyAsync(() -> {
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
