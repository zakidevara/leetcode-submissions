class Solution {
    public void rotate(int[] nums, int k) {
        k = k > nums.length ? k % nums.length : k;
        int[] temp = new int[k];
        for (int i = 0; i < temp.length; i++) {
            temp[temp.length - i - 1] = nums[nums.length - i - 1];
        }
        
        for (int i = 1; i <= nums.length - k; i++) {
            nums[nums.length-i] = nums[nums.length - i - k];
        }

        for (int i = 0; i < temp.length; i++) {
            nums[i] = temp[i];
        }
    }
}
