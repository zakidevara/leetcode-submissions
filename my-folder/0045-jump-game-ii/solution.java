class Solution {
    public int jump(int[] nums) {
        if (nums.length == 1) return 0;
        int index = 0;
        int jumpPower = nums[0];
        int jumps = 1;
        while (index + jumpPower < nums.length - 1) {
            int nextIndex = 0;
            int maxReach = -1;
            for (int i = index+1; i <= index+jumpPower; i++) {
                if (maxReach < nums[i] + i) {
                    maxReach = nums[i] + i;
                    nextIndex = i;
                }
            }
            index = nextIndex;
            jumpPower = nums[nextIndex];
            jumps++;
        }

        return jumps;
    }
}
