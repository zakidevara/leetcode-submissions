class Solution {
    public int removeDuplicates(int[] nums) {
        // [3,3,3,4,4,4,9,9,6,6]
        int k = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[k-1] != nums[i]) {
                int temp = nums[k];
                nums[k] = nums[i];
                nums[i] = temp;
                k++;
            }
        }

        return k;
    }
}
