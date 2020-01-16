package bean;

import lombok.Data;

@Data
public class ResultInfo extends Object {

    public ResultInfo() {
    }

    private UserInfo userInfo;

    private TrackInfo trackInfo;

    private AlbumInfo albumInfo;

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(~2));
    }

}
