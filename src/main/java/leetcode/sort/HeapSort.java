package leetcode.sort;

/**
 * @author rcli
 * Created on 2020/3/7.
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] arr = {16, 7, 3, 20, 17, 8};
        heapSort(arr,5);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void heapSort(int[] data, int len) {
        buildHeap(data, len);
        for (int i = len; i > 1; i--) {
            swap(data, 1, len);
            adjustDown(data, len, 1);
        }

    }

    private static void buildHeap(int[] data, int len) {
        for (int i = len / 2; i >= 1; i--) {
            adjustDown(data, len, i);
        }
    }

    private static void adjustDown(int[] data, int len, int i) {
        while (true) {
            int max = i;
            if (i * 2 <= len && data[i * 2] > data[i]) max = 2 * i;
            if (i * 2 + 1 <= len && data[i * 2 + 1] > data[i]) max = 2 * i + 1;
            if (max == i) break;
            swap(data, max, i);
            i = max;
        }
    }


    private static void swap(int[] data, int i, int j) {
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }


}
