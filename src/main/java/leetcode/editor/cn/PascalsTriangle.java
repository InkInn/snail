//给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
//
// 
//
// 在杨辉三角中，每个数是它左上方和右上方的数的和。 
//
// 示例: 
//
// 输入: 5
//输出:
//[
//     [1],
//    [1,1],
//   [1,2,1],
//  [1,3,3,1],
// [1,4,6,4,1]
//] 
// Related Topics 数组


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangle {
    public static void main(String[] args) {
        Solution solution = new PascalsTriangle().new Solution();
        solution.generate(5);
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> result = new ArrayList<>();
            if (numRows < 1) return result;
            List<Integer> first = Arrays.asList(1);
            result.add(first);
            if (numRows == 1) return result;
            for (int i = 1; i < numRows; i++) {
                List<Integer> tmp = build(i, result.get(i - 1));
                result.add(tmp); 
            }
            return result;
        }

        public List<Integer> build(int n, List<Integer> preList) {
            List<Integer> list = new ArrayList<>(n + 1);
            list.add(1);
            for (int i = 1; i < n; i++) {
                list.add(preList.get(i - 1) + preList.get(i));
            }
            list.add(1);
            return list;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}