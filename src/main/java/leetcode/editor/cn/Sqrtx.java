//实现 int sqrt(int x) 函数。
//
// 计算并返回 x 的平方根，其中 x 是非负整数。 
//
// 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。 
//
// 示例 1: 
//
// 输入: 4
//输出: 2
// 
//
// 示例 2: 
//
// 输入: 8
//输出: 2
//说明: 8 的平方根是 2.82842..., 
//     由于返回类型是整数，小数部分将被舍去。
// 
// Related Topics 数学 二分查找


package leetcode.editor.cn;

public class Sqrtx {
    public static void main(String[] args) {
        Solution solution = new Sqrtx().new Solution();
        System.out.println(solution.mySqrt(4));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int mySqrt(int x) {
            if (x == 0 || x == 1) return x;
            long left = 1;
            long right = x / 2;
            while (left < right) {
                long mid = left + (right - left + 1) / 2;
                if (x == mid * mid) return (int) mid;
                if (x > mid * mid) {
                    left = mid;
                } else {
                    right = mid - 1;
                }
            }
            return (int) left;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    class SolutionFloat {
        public double mySqrt(int x) {
            if (x == 0) return 0;
            double left = 1;
            double right = x;
            double mid = 0;
            while (right - left > 0.00001) {
                mid = (left + right) / 2;
                double sqrt = mid * mid;
                if (sqrt > x) {
                    right = mid;
                } else {
                    left = mid;
                }
            }
            return mid;
        }
    }
}