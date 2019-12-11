package leetcode.sort;

import com.alibaba.fastjson.JSON;

/**
 * @author rcli
 * Created on 2019/10/31.
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] num = {1, 4, 5, 2, 10};
        quickSort(num, 0, num.length - 1);
        System.out.println(JSON.toJSONString(num));
    }

    private static void quickSort(int[] a, int head, int tail) {
        if (head >= tail) return;

        int sentry = partition(a, head, tail);
        quickSort(a, head, sentry - 1);
        quickSort(a, sentry + 1, tail);
    }

    private static int partition(int[] a, int head, int tail) {
        int sentry = a[head];
        while (head < tail) {
            while (head < tail && a[tail] >= sentry) {
                tail--;
            }
            a[head] = a[tail];
            while (head < tail && a[head] <= sentry) {
                head++;
            }
            a[tail] = a[head];
        }
        a[head] = sentry;
        return head;
    }

}
