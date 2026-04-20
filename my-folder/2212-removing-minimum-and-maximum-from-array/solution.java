class Solution {
    public int minimumDeletions(int[] nums) {
        if (nums.length == 0) return 0;

        int minIdx = 0;
        int maxIdx = 0;
        for (int i = 0; i < nums.length; i++) {
            // set max
            if (nums[maxIdx] < nums[i]) maxIdx = i;

            // set min
            if (nums[minIdx] > nums[i]) minIdx = i;
        }

        // compare deletions
        // 1. from front
        // 2. from back
        // 3. combination

        int frontDeletion = Math.max(minIdx, maxIdx) + 1;
        int backDeletion = nums.length - Math.min(minIdx, maxIdx);
        int combinationDeletion = (Math.min(minIdx, maxIdx) + 1) + (nums.length - Math.max(minIdx, maxIdx));

        return Math.min(Math.min(frontDeletion, backDeletion), combinationDeletion);
    }
}
