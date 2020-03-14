package leetcode.sort;

/**
 * @author rcli
 * Created on 2020/3/14.
 */
public class QuickSort {

    public void quickSort(int nums[], int low, int high) {
        int i = low;
        int j = high;
        if (low >= high) return;
        int index = nums[low];
        while (i < j) {
            while (i < j && nums[j] >= index) j--;
            if (i < j) nums[i++] = nums[j];
            while (i < j && nums[i] <= index) i++;
            if (i < j) nums[j--] = nums[i];
        }
        nums[i] = index;
        quickSort(nums, low, i - 1);
        quickSort(nums, i + 1, high);

    }
}
