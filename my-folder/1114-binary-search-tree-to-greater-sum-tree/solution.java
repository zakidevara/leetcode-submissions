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
    public TreeNode bstToGst(TreeNode root) {
        
        postOrderGreaterTree(root, 0);
        return root;
    }
    
    private int postOrderGreaterTree(TreeNode node, int rollingSum) {
        if (node == null) return rollingSum;
        
        int rightSum = postOrderGreaterTree(node.right, rollingSum);
        node.val = node.val + rightSum;
        
        int leftSum = postOrderGreaterTree(node.left, node.val);
        
        return leftSum;
    }
}
