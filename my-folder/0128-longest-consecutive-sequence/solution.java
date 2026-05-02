class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int longest = 0;
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        for (int num : set) {
            if (!set.contains(num-1)) {
                int nextConsecutive = num + 1;
                while (set.contains(nextConsecutive)) {
                    nextConsecutive++;
                }

                longest = Math.max(longest, nextConsecutive-num);
            }
        }
        
        return longest;
    }
}
