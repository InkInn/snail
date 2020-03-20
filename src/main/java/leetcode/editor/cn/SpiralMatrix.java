//给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
//
// 示例 1: 
//
// 输入:
//[
// [ 1, 2, 3 ],
// [ 4, 5, 6 ],
// [ 7, 8, 9 ]
//]
//输出: [1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2: 
//
// 输入:
//[
//  [1, 2, 3, 4],
//  [5, 6, 7, 8],
//  [9,10,11,12]
//]
//输出: [1,2,3,4,8,12,11,10,9,5,6,7]
// 
// Related Topics 数组


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        Solution solution = new SpiralMatrix().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> result = new ArrayList<>();
            if (matrix.length == 0) return result;
            int rowStart = 0, rowEnd = matrix.length - 1;
            int colStart = 0, colEnd = matrix[0].length - 1;
            while (rowStart <= rowEnd && colStart <= colEnd) {
                for (int col = colStart; col <= colEnd; col++) result.add(matrix[rowStart][col]);
                for (int row = rowStart + 1; row <= rowEnd; row++) result.add(matrix[row][colEnd]);
                if (rowStart < rowEnd && colStart < colEnd) {
                    for (int col = colEnd - 1; col > colStart; col--) result.add(matrix[rowEnd][col]);
                    for (int row = rowEnd; row > rowStart; row--) result.add(matrix[row][colStart]);
                }
                rowStart++;
                rowEnd--;
                colStart++;
                colEnd--;
            }
            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}