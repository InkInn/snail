//给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
//
// 示例: 
//
// 输入: "25525511135"
//输出: ["255.255.11.135", "255.255.111.35"] 
// Related Topics 字符串 回溯算法


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddresses {
    public static void main(String[] args) {
        Solution solution = new RestoreIpAddresses().new Solution();
        solution.restoreIpAddresses("25525511135");
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> restoreIpAddresses(String s) {
            List<String> result = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            for (int a = 1; a < 4; a++)
                for (int b = 1; b < 4; b++)
                    for (int c = 1; c < 4; c++)
                        for (int d = 1; d < 4; d++) {
                            if (a + b + c + d == s.length()) {
                                int n1 = Integer.parseInt(s.substring(0, a));
                                int n2 = Integer.parseInt(s.substring(a, a + b));
                                int n3 = Integer.parseInt(s.substring(a + b, a + b + c));
                                int n4 = Integer.parseInt(s.substring(a + b + c));
                                if (n1 <= 255 && n2 <= 255 && n3 <= 255 && n4 <= 255) {
                                    sb.append(n1).append(".").append(n2).append(".").append(n3).append(".").append(n4);
                                    if (sb.length() == s.length() + 3) {
                                        result.add(sb.toString());

                                    }
                                    sb.delete(0, sb.length());
                                }
                            }
                        }
            return result;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)
}