class Solution {
    public int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        
        while (left < right) {
            int mid = left + (right-left)/2;
            boolean isPairIntact;

            if (mid % 2 == 0) {
                isPairIntact = (nums[mid] == nums[mid + 1]);
            } else {
                isPairIntact = (nums[mid] == nums[mid - 1]);
            }
            
            if (isPairIntact) {
                left = mid + 1;
            } else {
                right = mid;
            }
            
        }
        
        return nums[left];
    }
}
