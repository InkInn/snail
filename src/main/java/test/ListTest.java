package test;

/**
 * @author rcli
 * Created on 2019/8/28.
 */
public class ListTest {

    public static void main(String[] args) {
        int s1 = 0, s2 = 0;
        for (int i = 0; i < 1000; i++) {
            int random = (int) (Math.random() * 100);
            if (random < 0) {
                s1++;
            } else {
                s2++;
            }
        }
        System.out.println("s1: " + s1 + "      s2: " + s2);
    }
}
