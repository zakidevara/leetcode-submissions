/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number[][]}
 */
var levelOrder = function(root) {
    if (root == null) return [];
    let queue = [root];
    let result = [];
    while (queue.length > 0) {
        let currLength = queue.length;
        let currLevel = [];
        for (let i = 0; i < currLength; i++) {
            if (queue[0].left != null) {
                queue.push(queue[0].left);
            }
            if (queue[0].right != null) {
                queue.push(queue[0].right);
            }
            currLevel.push(queue[0].val);
            queue.shift();
        }
        result.push(currLevel);
    }

    return result;
};
