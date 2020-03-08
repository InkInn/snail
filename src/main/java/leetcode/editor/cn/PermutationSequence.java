//给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
//
// 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下： 
//
// 
// "123" 
// "132" 
// "213" 
// "231" 
// "312" 
// "321" 
// 
//
// 给定 n 和 k，返回第 k 个排列。 
//
// 说明： 
//
// 
// 给定 n 的范围是 [1, 9]。 
// 给定 k 的范围是[1, n!]。 
// 
//
// 示例 1: 
//
// 输入: n = 3, k = 3
//输出: "213"
// 
//
// 示例 2: 
//
// 输入: n = 4, k = 9
//输出: "2314"
// 
// Related Topics 数学 回溯算法


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {
    public static void main(String[] args) {
        Solution solution = new PermutationSequence().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String getPermutation(int n, int k) {
            boolean[] visited = new boolean[n];
            return recursive(n, factorial(n - 1), k, visited);
        }

        private String recursive(int n, int f, int k, boolean[] visited) {
            int offset = k % f;
            int groupIndex = k / f + (offset > 0 ? 1 : 0);
            int i = 0;
            for (; i < visited.length && groupIndex > 0; i++) {
                if (!visited[i]) {
                    groupIndex--;
                }
            }
            visited[i - 1] = true;
            if (n - 1 > 0) {
                return i + recursive(n - 1, f / (n - 1), offset == 0 ? f : offset, visited);
            } else {
                return String.valueOf(i);
            }

        }

        private int factorial(int n) {
            int res = 1;
            for (int i = n; i > 1; i--) {
                res *= i;
            }
            return res;
        }

        // 解法二
        public String getPermutation2(int n, int k) {
            int[] factorials = new int[n];
            List<Integer> nums = new ArrayList<>();
            factorials[0] = 1;
            for (int i = 1; i < n; ++i) {
                factorials[i] = factorials[i - 1] * i;
                nums.add(i + 1);
            }
            --k;
            StringBuilder sb = new StringBuilder();
            for (int i = n - 1; i > -1; --i) {
                int idx = k / factorials[i];
                k -= idx * factorials[i];
                sb.append(nums.get(idx));
                nums.remove(idx);
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}