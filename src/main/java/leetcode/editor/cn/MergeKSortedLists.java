//合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
//
// 示例: 
//
// 输入:
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//输出: 1->1->2->3->4->4->5->6 
// Related Topics 堆 链表 分治算法


package leetcode.editor.cn;

public class MergeKSortedLists {
    public static void main(String[] args) {
        Solution solution = new MergeKSortedLists().new Solution();
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
        public ListNode mergeKLists(ListNode[] lists) {
            int len = lists.length;
            if (len == 0) return null;
            while (len > 1) {
                for (int i = 0; i < len / 2; i++) {
                    lists[i] = mergeTwoLists(lists[i], lists[len - 1 - i]);
                }
                len = (len + 1) / 2;
            }
            return lists[0];
        }

        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode head = new ListNode(0);
            ListNode dummy = head;
            while (l1 != null || l2 != null) {
                if (l1 != null && l2 != null) {
                    if (l1.val < l2.val) {
                        head.next = l1;
                        l1 = l1.next;
                    } else {
                        head.next = l2;
                        l2 = l2.next;
                    }
                } else if (l1 != null) {
                    head.next = l1;
                    l1 = l1.next;
                } else {
                    head.next = l2;
                    l2 = l2.next;
                }
                head = head.next;
            }
            return dummy.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}