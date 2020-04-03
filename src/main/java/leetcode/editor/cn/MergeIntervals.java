//给出一个区间的集合，请合并所有重叠的区间。
//
// 示例 1: 
//
// 输入: [[1,3],[2,6],[8,10],[15,18]]
//输出: [[1,6],[8,10],[15,18]]
//解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2: 
//
// 输入: [[1,4],[4,5]]
//输出: [[1,5]]
//解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。 
// Related Topics 排序 数组


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class MergeIntervals {
    public static void main(String[] args) {
        Solution solution = new MergeIntervals().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] merge(int[][] intervals) {
            LinkedList<int[]> result = new LinkedList<>();
            if (intervals == null || intervals.length == 0) return result.toArray(new int[0][]);
            Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
            for (int i = 0; i < intervals.length; i++) {
                if (result.isEmpty() || result.getLast()[1] < intervals[i][0]) {
                    result.add(intervals[i]);
                } else {
                    result.getLast()[1] = Math.max(result.getLast()[1], intervals[i][1]);
                }
            }
            return result.toArray(new int[0][]);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}