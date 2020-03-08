package leetcode.sort;

/**
 * @author rcli
 * Created on 2020/3/7.
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] arr = {16, 7, 3, 20, 17, 8};
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }


    public void adjustDown(int[] nums, int size, int k) {
        int tmp = nums[k];
        for (int i = 2 * k; i < size; i = i * 2) {
            if (i + 1 < size && nums[i] < nums[i + 1]) i++;
            if (nums[k] >= nums[i]) break;
            else {
                nums[k] = nums[i];
                k = i;
            }
        }
        nums[k] = tmp;
    }

    public void adjustUp(int[] nums, int k){
        int loc = k - 1;
        int tmp = nums[loc];
        int i = loc /2;
        while(nums[i] < tmp){
            nums[loc] = nums[i];
            loc = i;
            i = loc/2;
        }
        nums[loc] = tmp;
    }

    void buildMaxHeap(int a[], int size){
        for(int i = (size - 1) /2; i >= 0; i--){
            adjustDown(a,size,i);
        }
    }


}
