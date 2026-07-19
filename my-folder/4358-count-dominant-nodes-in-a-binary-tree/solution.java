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
    public int countDominantNodes(TreeNode root) {
        int[] dominantCount = new int[]{0};
        internalCountDominantNodes(root, dominantCount);
        return dominantCount[0];
    }

    private int internalCountDominantNodes(TreeNode node, int[] dominantCount) {
        if (node == null) return 0;

        int maxLeft = internalCountDominantNodes(node.left, dominantCount);
        int maxRight = internalCountDominantNodes(node.right, dominantCount);

        if (node.val >= maxLeft && node.val >= maxRight) {
            dominantCount[0]++;
        }

        return Math.max(maxRight, Math.max(node.val, maxLeft));
    }
}
