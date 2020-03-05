//给定一个二叉搜索树的根结点 root, 返回树中任意两节点的差的最小值。
//
// 示例： 
//
// 
//输入: root = [4,2,6,1,3,null,null]
//输出: 1
//解释:
//注意，root是树结点对象(TreeNode object)，而不是数组。
//
//给定的树 [4,2,6,1,3,null,null] 可表示为下图:
//
//          4
//        /   \
//      2      6
//     / \    
//    1   3  
//
//最小的差值是 1, 它是节点1和节点2的差值, 也是节点3和节点2的差值。 
//
// 注意： 
//
// 
// 二叉树的大小范围在 2 到 100。 
// 二叉树总是有效的，每个节点的值都是整数，且不重复。 
// 
// Related Topics 树 递归


package leetcode.editor.cn;

public class MinimumDistanceBetweenBstNodes {
    public static void main(String[] args) {
        Solution solution = new MinimumDistanceBetweenBstNodes().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        Integer pre;
        Integer result;

        public int minDiffInBST(TreeNode root) {
            pre = null;
            result = Integer.MAX_VALUE;
            dfs(root);
            return result;
        }

        private void dfs(TreeNode node) {
            if (node == null) return;
            dfs(node.left);
            if (pre != null) {
                result = Math.min(node.val - pre, result);
            }
            pre = node.val;
            dfs(node.right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}