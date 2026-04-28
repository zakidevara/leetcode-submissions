/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int goodNodes(TreeNode root) {
        return internalGoodNodes(root, root.val);
    }

    public int internalGoodNodes(TreeNode node, int max) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) return node.val >= max ? 1 : 0;
        

        int left = node.left != null ? internalGoodNodes(node.left, Math.max(max, node.left.val)) : 0;
        int right = node.right != null ? internalGoodNodes(node.right, Math.max(max, node.right.val)) : 0;
        return (node.val >= max ? 1 : 0) + left + right;
    }
}
