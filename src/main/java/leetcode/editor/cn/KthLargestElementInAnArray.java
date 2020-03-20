//在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
//
// 示例 1: 
//
// 输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4 
//
// 说明: 
//
// 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。 
// Related Topics 堆 分治算法


package leetcode.editor.cn;

public class KthLargestElementInAnArray {
    public static void main(String[] args) {
        Solution solution = new KthLargestElementInAnArray().new Solution();
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        solution.findKthLargest(nums, 4);
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            if (nums == null || nums.length == 0 || k > nums.length) return -1;
            int[] data = new int[k + 1];
            for (int i = 1; i <= k; i++) {
                data[i] = nums[i - 1];
            }
            buildHeap(data, k);
            for (int i = k; i < nums.length; i++) {
                if (nums[i] > data[1]) {
                    data[1] = nums[i];
                    adjustDown(data, k, 1);
                }
            }
            return data[1];
        }


        public void buildHeap(int[] nums, int len) {
            for (int i = len / 2; i >= 1; i--) {
                adjustDown(nums, len, i);
            }
        }

        public void adjustDown(int[] nums, int len, int i) {
            while (true) {
                int max = i;
                if (2 * i <= len && nums[i * 2] < nums[i]) max = i * 2;
                if (2 * i + 1 <= len && nums[i * 2 + 1] < nums[i]) max = 2 * i + 1;
                if (max == i) break;
                int tmp = nums[i];
                nums[i] = nums[max];
                nums[max] = tmp;
                i = max;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}