class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if ((i > 0 && nums[i] == nums[i-1]) || nums[i] > 0) continue;

            int j = i+1;
            int k = nums.length-1;
            int target = -1 * nums[i];

            while (j < k) {
                if (j > i+1 && nums[j] == nums[j-1]) {
                    j++;
                    continue;
                }
                int currSum = nums[j] + nums[k];
                if (currSum == target) {
                    result.add(List.of(nums[i], nums[j], nums[k]));
                    j++;
                } else if (currSum > target) {
                    k--;
                } else {
                    j++;
                }
            }
        }

        return result;
    }
}
