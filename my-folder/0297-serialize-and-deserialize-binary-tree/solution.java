/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preorderSerialize(root, sb);

        return sb.toString();
    }

    private void preorderSerialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("x,");
            return;
        }

        sb.append(root.val).append(",");

        preorderSerialize(root.left, sb);
        preorderSerialize(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");

        Queue<String> q = new LinkedList<>();

        q.addAll(Arrays.asList(arr));

        return preorderDeserialize(q);
    }

    private TreeNode preorderDeserialize(Queue<String> q) {
        String curr = q.poll();

        if (curr.equals("x")) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(curr));

        root.left = preorderDeserialize(q);
        root.right = preorderDeserialize(q);

        return root;

    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
