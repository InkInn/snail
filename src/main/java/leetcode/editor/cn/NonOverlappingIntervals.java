//给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
//
// 注意: 
//
// 
// 可以认为区间的终点总是大于它的起点。 
// 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。 
// 
//
// 示例 1: 
//
// 
//输入: [ [1,2], [2,3], [3,4], [1,3] ]
//
//输出: 1
//
//解释: 移除 [1,3] 后，剩下的区间没有重叠。
// 
//
// 示例 2: 
//
// 
//输入: [ [1,2], [1,2], [1,2] ]
//
//输出: 2
//
//解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
// 
//
// 示例 3: 
//
// 
//输入: [ [1,2], [2,3] ]
//
//输出: 0
//
//解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
// 
// Related Topics 贪心算法


package leetcode.editor.cn;

import java.util.Arrays;

public class NonOverlappingIntervals {
    public static void main(String[] args) {
        Solution solution = new NonOverlappingIntervals().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int eraseOverlapIntervals(int[][] intervals) {
            if (intervals.length == 0) return 0;
            Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
            int[] dp = new int[intervals.length];
            dp[0] = 1;
            int ans = 1;
            for (int i = 1; i < dp.length; i++) {
                int max = 0;
                for (int j = i - 1; j >= 0; j--) {
                    if (intervals[i][0] - intervals[j][1] >= 0) {
                        max = Math.max(dp[j], max);
                    }
                }
                dp[i] = max + 1;
                ans = Math.max(ans, dp[i]);
            }
            return intervals.length - ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}