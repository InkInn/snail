package leetcode.sort;

import com.alibaba.fastjson.JSON;

/**
 * @author rcli
 * Created on 2019/10/31.
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] num = {1, 4, 5, 2, 10};
        bubbleSort(num,num.length);
        System.out.println(JSON.toJSONString(num));
    }

    private static void bubbleSort(int[] a, int n) {
        if (n <= 1) return;
        for (int i = 0; i < n; i++) {
            boolean flag = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    flag = true;
                }
            }
            if (!flag) break;
        }
    }
}
