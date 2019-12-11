package leetcode.sort;

import com.alibaba.fastjson.JSON;

/**
 * @author rcli
 * Created on 2019/10/31.
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] num = {1, 4, 5, 2, 10};
        mergeSort(num, 0, num.length - 1);
        System.out.println(JSON.toJSONString(num));
    }

    private static void mergeSort(int[] a, int head, int tail) {
        if (head >= tail) return;

        int mid = (head + tail) / 2;

        mergeSort(a, head, mid);
        mergeSort(a, mid + 1, tail);
        merge(a, head, mid, tail);
    }

    private static void merge(int[] a, int head, int mid, int tail) {
        int i = head;
        int j = mid + 1;
        int k = 0;
        int[] tmp = new int[tail - head + 1];
        while (i <= mid && j < tail) {
            if (a[i] <= a[j]) {
                tmp[k++] = a[i++];
            } else {
                tmp[k++] = a[j++];
            }
        }

        int start = i;
        int end = mid;
        if (j <= tail) {
            start = j;
            end = tail;
        }

        while (start <= end) {
            tmp[k++] = a[start++];
        }

        for (i = 0; i <= tail - head; i++) {
            a[head + i] = tmp[i];
        }
    }

    private static void mergeBySentry(int[] a, int head, int mid, int tail) {
        int[] left = new int[mid - head + 2];
        int[] right = new int[tail - mid + 1];

        for (int i = 0; i <= mid - head; i++) {
            left[i] = a[head + i];
        }
        left[mid - head + 1] = Integer.MAX_VALUE;

        for (int i = 0; i < tail - mid; i++) {
            right[i] = a[mid + 1 + i];
        }

        right[tail - mid] = Integer.MAX_VALUE;

        int i = 0;
        int j = 0;
        int k = head;

        while (k <= tail) {
            if (left[i] <= right[j]) {
                a[k++] = left[i++];
            } else {
                a[k++] = right[j++];
            }
        }
    }
}
