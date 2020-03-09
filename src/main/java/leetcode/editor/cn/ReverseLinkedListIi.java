//反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
//
// 说明: 
//1 ≤ m ≤ n ≤ 链表长度。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL, m = 2, n = 4
//输出: 1->4->3->2->5->NULL 
// Related Topics 链表


package leetcode.editor.cn;

public class ReverseLinkedListIi {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        Solution solution = new ReverseLinkedListIi().new Solution();
        ListNode node = new ListNode(3);
        ListNode node2 = new ListNode(5);
        node.next = node2;
        solution.reverseBetween(node, 1, 2);

    }


    /**
     * Definition for singly-linked list
     **/


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public ListNode reverseBetween(ListNode head, int m, int n) {
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode node = dummy;
            for (int i = 1; i < m; i++) {
                dummy = dummy.next;
            }
            head = dummy.next;
            for (int i = m; i < n; i++) {
                ListNode next = head.next;
                head.next = next.next;
                next.next = dummy.next;
                dummy.next = next;
            }
            return node.next;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}