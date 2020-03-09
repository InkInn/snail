//在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
//
// 示例: 
//
// 输入: 
//
//1 0 1 0 0
//1 0 1 1 1
//1 1 1 1 1
//1 0 0 1 0
//
//输出: 4 
// Related Topics 动态规划


package leetcode.editor.cn;

public class MaximalSquare {
    public static void main(String[] args) {
        Solution solution = new MaximalSquare().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximalSquare(char[][] matrix) {
            int rows = matrix.length;
            int cols = rows > 0 ? matrix[0].length : 0;
            int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];
            int maxLen = 0;
            for (int i = 1; i <= rows; i++) {
                for (int j = 1; j <= cols; j++) {
                    if (matrix[i - 1][j - 1] == '1') {
                        dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
                        maxLen = Math.max(maxLen, dp[i][j]);
                    }
                }
            }
            return maxLen * maxLen;

        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}