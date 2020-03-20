package leetcode.sort;

/**
 * @author rcli
 * Created on 2020/3/14.
 */
public class MergeSort {

    public static void mergeSort(int[] nums, int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            mergeSort(nums, low, mid);
            mergeSort(nums, mid + 1, high);
            merge(nums, low, mid, high);
        }
    }

    public static void merge(int[] nums, int low, int mid, int high) {
        int[] tmp = new int[high - low + 1];
        int i = low;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= high) {
            if (nums[i] < nums[j]) tmp[k++] = nums[i++];
            else tmp[k++] = nums[j++];
        }
        while (i <= mid) {
            tmp[k++] = nums[i++];
        }

        while (j <= high) {
            tmp[k++] = nums[j++];
        }

        for (int z = 0; z < tmp.length; z++) {
            nums[z + low] = tmp[z];
        }
    }
}
