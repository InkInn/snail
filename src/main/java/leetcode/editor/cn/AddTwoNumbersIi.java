//给定两个非空链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储单个数字。将这两数相加会返回一个新的链表。
//
// 
//
// 你可以假设除了数字 0 之外，这两个数字都不会以零开头。 
//
// 进阶: 
//
// 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。 
//
// 示例: 
//
// 
//输入: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出: 7 -> 8 -> 0 -> 7
// 
// Related Topics 链表


package leetcode.editor.cn;

public class AddTwoNumbersIi {
    public static void main(String[] args) {
        Solution solution = new AddTwoNumbersIi().new Solution();
    }


    /**
     * Definition for singly-linked list.
     **/
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode dummy = new ListNode(0);
            ListNode head = dummy;
            int tmp = 0;
            while (l1 != null || l2 != null) {
                int sum = 0;
                if (l1 != null && l2 != null) {
                    sum = tmp + l1.val + l2.val;
                    l1 = l1.next;
                    l2 = l2.next;
                } else if (l1 == null) {
                    sum = tmp + l2.val;
                    l2 = l2.next;
                } else {
                    sum = tmp + l1.val;
                    l1 = l1.next;
                }
                int cur = sum % 10;
                tmp = sum / 10;
                dummy.next = new ListNode(cur);
                dummy = dummy.next;
            }
            if (tmp > 0) dummy.next = new ListNode(tmp);
            return head.next;

        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}