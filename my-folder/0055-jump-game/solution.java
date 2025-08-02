class Solution {
    public boolean canJump(int[] nums) {
        int lastReachableIndex = nums.length - 1;
        for (int i = nums.length-1; i >= 0; i--) {
            int currMaxStep = nums[i];
            if (i + currMaxStep >= lastReachableIndex) {
                lastReachableIndex = i;
            }
        }

        return lastReachableIndex == 0;
    }
}
