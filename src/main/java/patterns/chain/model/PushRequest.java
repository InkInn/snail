package patterns.chain.model;

import lombok.Data;

/**
 * @author rcli
 * Created on 2019/8/25.
 */

@Data
public class PushRequest {

    private Integer msgType;

    private String value;
}
