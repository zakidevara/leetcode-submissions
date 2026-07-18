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
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> leftBoundary = findLeftBoundary(root.left);
        
        
        List<Integer> leaves = root.left == null && root.right == null ? List.of() : findLeaves(root);
        List<Integer> rightBoundary = findRightBoundary(root.right);
        
        
        
        
        List<Integer> result = new ArrayList<>();
        result.add(root.val);
        result.addAll(leftBoundary);
        result.addAll(leaves);
        result.addAll(rightBoundary);
        
        return result;
    }
    
    private List<Integer> findLeftBoundary(TreeNode node) {
        if (node == null || node.right == null && node.left == null) return List.of();
        
        List<Integer> result = new ArrayList<>();
        result.add(node.val);
        
        if (node.left != null) {
            List<Integer> left = findLeftBoundary(node.left);
            result.addAll(left);
        } else if (node.right != null) {
            List<Integer> right = findLeftBoundary(node.right);
            result.addAll(right);
        }
        
        return result;
        
    }
    
    
    private List<Integer> findRightBoundary(TreeNode node) {
        if (node == null || node.right == null && node.left == null) return List.of();
        
        List<Integer> result = new ArrayList<>();
        
        if (node.right != null) {
            List<Integer> right = findRightBoundary(node.right);
            result.addAll(right);
        } else if (node.left != null) {
            List<Integer> left = findRightBoundary(node.left);
            result.addAll(left);
        }
        
        result.add(node.val);
        return result;
        
    }
    
    private List<Integer> findLeaves(TreeNode node) {
        if (node.right == null && node.left == null) return List.of(node.val);
        List<Integer> result = new ArrayList<>();
        
        if (node.left != null) {
            List<Integer> left = findLeaves(node.left);
            result.addAll(left);
        }
        
        if (node.right != null) {
            List<Integer> right = findLeaves(node.right);
            result.addAll(right);
        } 
        
        return result;
    }
}
