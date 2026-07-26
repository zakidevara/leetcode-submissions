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
    private int index = 0;
    public TreeNode bstFromPreorder(int[] preorder) {

        return solve(preorder, Integer.MAX_VALUE);
    }
    
    private TreeNode solve(int[] preorder, int bound) {
        if (index == preorder.length || preorder[index] > bound) {
            return null;
        }
        
        TreeNode node = new TreeNode(preorder[index++]);
        
        node.left = solve(preorder, node.val);
        node.right = solve(preorder, bound);
        
        return node;
    }
}
