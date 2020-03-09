//给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
//
// 换句话说，第一个字符串的排列之一是第二个字符串的子串。 
//
// 示例1: 
//
// 
//输入: s1 = "ab" s2 = "eidbaooo"
//输出: True
//解释: s2 包含 s1 的排列之一 ("ba").
// 
//
// 
//
// 示例2: 
//
// 
//输入: s1= "ab" s2 = "eidboaoo"
//输出: False
// 
//
// 
//
// 注意： 
//
// 
// 输入的字符串只包含小写字母 
// 两个字符串的长度都在 [1, 10,000] 之间 
// 
// Related Topics 双指针 Sliding Window


package leetcode.editor.cn;

public class PermutationInString {
    public static void main(String[] args) {
        Solution solution = new PermutationInString().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkInclusion(String s1, String s2) {
            if (s1.length() > s2.length()) return false;
            int[] map1 = new int[26];
            int[] map2 = new int[26];
            for (int i = 0; i < s1.length(); i++) {
                map1[s1.charAt(i) - 'a']++;
                map2[s2.charAt(i) - 'a']++;
            }
            for (int i = s1.length(); i < s2.length(); i++) {
                if (judge(map1, map2)) return true;
                map2[s2.charAt(i - s1.length()) - 'a']--;
                map2[s2.charAt(i) - 'a']++;
            }
            return judge(map1, map2);
        }

        public boolean judge(int[] map1, int[] map2) {
            for (int i = 0; i < 26; i++) {
                if (map1[i] != map2[i]) return false;
            }
            return true;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

}