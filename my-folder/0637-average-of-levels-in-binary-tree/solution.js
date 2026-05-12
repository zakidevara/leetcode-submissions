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
 * @return {number[]}
 */
var averageOfLevels = function(root) {
    let queue = [root];
    let result = [];

    let currLevel = 0;
    while (queue.length > 0) {
        let sum = 0;
        let nonNullCount = 0;
        let currQueueLength = queue.length;
        for (let i = 0; i < currQueueLength; i++) {
            sum += queue[0].val;
            if (queue[0].left != null) {
                queue.push(queue[0].left);
            }
            if (queue[0].right != null) {
                queue.push(queue[0].right);
            }
            queue.shift();
        }
        let avg = sum/currQueueLength;

        result.push(avg);
        currLevel++;
    }

    return result;
};
