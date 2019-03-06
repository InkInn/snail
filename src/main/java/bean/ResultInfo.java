package bean;

import lombok.Data;

@Data
public class ResultInfo {

    public ResultInfo() {
    }

    private UserInfo userInfo;

    private TrackInfo trackInfo;

    private AlbumInfo albumInfo;

}
