class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 0;
        int front = 0;
        int back = nums.length - 1;

        while (front < back) {
            int sum = nums[front] + nums[back];

            if (sum == k) {
                count++;
                front++;
                back--;
            } else if (sum > k) {
                back--;
            } else {
                front++;
            }
        }

        return count;
    }
}
