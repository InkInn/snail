//反转一个单链表。
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 进阶: 
//你可以迭代或递归地反转链表。你能否用两种方法解决这道题？ 
// Related Topics 链表


package leetcode.editor.cn;

public class ReverseLinkedList {
    public static void main(String[] args) {
        Solution solution = new ReverseLinkedList().new Solution();
    }


    /**
     * Definition for singly-linked list.
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public ListNode reverseList(ListNode head) {
            if(head == null) return null;
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            while (head.next != null) {
                ListNode next = head.next;
                head.next = next.next;
                next.next = dummy.next;
                dummy.next = next;
            }
            return dummy.next;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}