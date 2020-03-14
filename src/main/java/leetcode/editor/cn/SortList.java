//在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
//
// 示例 1: 
//
// 输入: 4->2->1->3
//输出: 1->2->3->4
// 
//
// 示例 2: 
//
// 输入: -1->5->3->4->0
//输出: -1->0->3->4->5 
// Related Topics 排序 链表


package leetcode.editor.cn;

public class SortList {
    public static void main(String[] args) {
        Solution solution = new SortList().new Solution();
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
        public ListNode sortList(ListNode head) {
            return head == null ? null : mergeSort(head);
        }

        private ListNode mergeSort(ListNode head) {
            if (head.next == null) return head;
            ListNode p = head;
            ListNode q = head;
            ListNode pre = null;
            while (q != null && q.next != null) {
                pre = p;
                p = p.next;
                q = q.next.next;
            }
            pre.next = null;
            ListNode l = mergeSort(head);
            ListNode r = mergeSort(p);
            return merge(l, r);
        }

        private ListNode merge(ListNode l, ListNode r) {
            ListNode dummyHead = new ListNode(0);
            ListNode cur = dummyHead;
            while (l != null && r != null) {
                if (l.val <= r.val) {
                    cur.next = l;
                    cur = cur.next;
                    l = l.next;
                } else {
                    cur.next = r;
                    cur = cur.next;
                    r = r.next;
                }
            }
            if (l != null) {
                cur.next = l;
            }
            if (r != null) {
                cur.next = r;
            }
            return dummyHead.next;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}