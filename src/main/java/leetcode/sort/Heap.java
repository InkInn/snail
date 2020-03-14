package leetcode.sort;

/**
 * @author rcli
 * Created on 2020/3/14.
 */
public class Heap {

    // 从下标1开始存储数据
    private int[] data;

    // 容量
    private int capacity;

    // 已经存储的个数
    private int count;

    public Heap(int capacity) {
        this.data = new int[capacity + 1];
        this.capacity = capacity;
        count = 0;
    }


    public void insert(int num) {
        if (count >= capacity) return;
        count++;
        data[count] = num;
        adjustUp(count);
    }

    private void adjustUp(int len) {
        while (len / 2 > 0 && data[len] > data[len / 2]) {
            swap(data, len, len / 2);
            len = len / 2;
        }
    }

    public void removeMax() {
        if (count == 0) return;
        data[1] = data[count];
        count--;
        adjustDown(data, count, 1);
    }

    private void adjustDown(int[] data, int len, int i) {
        while (true) {
            int maxPos = i;
            if (i * 2 <= len && data[i] < data[i * 2]) maxPos = i * 2;
            if (i * 2 + 1 <= len && data[maxPos] < data[i * 2 + 1]) maxPos = i * 2 + 1;
            if (maxPos == i) break;
            swap(data, i, maxPos);
            i = maxPos;
        }
    }

    private void buildHeap(int[] data, int len) {
        for (int i = len / 2; i >= 1; i--) {
            adjustDown(data, len, i);
        }
    }


    public void sort(int[] data, int len) {
        buildHeap(data, len);
        for (int i = len; i > 1; i--) {
            swap(data, 1, len);
            adjustDown(data, len, 1);
        }
    }


    private void swap(int[] data, int i, int j) {
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }

}
