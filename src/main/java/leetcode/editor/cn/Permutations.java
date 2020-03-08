//给定一个没有重复数字的序列，返回其所有可能的全排列。
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        Solution solution = new Permutations().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> result = new LinkedList<>();
            ArrayList<Integer> numsList = new ArrayList<>();
            for (int num : nums) numsList.add(num);
            int n = nums.length;
            backTrack(n, numsList, result, 0);
            return result;
        }

        public void backTrack(int n, ArrayList<Integer> nums, List<List<Integer>> result, int first) {
            if (first == n) result.add(new ArrayList<>(nums));
            for (int i = first; i < n; i++) {
                Collections.swap(nums, first, i);
                backTrack(n, nums, result, first + 1);
                Collections.swap(nums, first, i);
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}