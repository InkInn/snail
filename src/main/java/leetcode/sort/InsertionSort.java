package leetcode.sort;

import com.alibaba.fastjson.JSON;

/**
 * @author rcli
 * Created on 2019/10/31.
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] num = {1, 4, 5, 2, 10};
        insertionSort(num, num.length);
        System.out.println(JSON.toJSONString(num));
    }

    private static void insertionSort(int[] a, int n) {
        if (n <= 1) return;
        for (int i = 1; i < n; i++) {
            int value = a[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (a[j] > value) {
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            a[j + 1] = value;
        }
    }
}
