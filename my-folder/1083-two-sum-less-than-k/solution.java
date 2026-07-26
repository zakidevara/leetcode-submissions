class Solution {
    public int twoSumLessThanK(int[] nums, int k) {
        int max = -1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                if (sum < k) max = Math.max(max, sum);
            }
        }   
        
        return max;
    }
}
