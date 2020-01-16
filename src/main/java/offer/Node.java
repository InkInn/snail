package offer;

import lombok.Data;

/**
 * @author rcli
 * Created on 2019/12/14.
 */

@Data
public class Node {

    public Node pre;

    public Node next;

    public int value;

    public Node(int value) {
        this.value = value;
    }
}
