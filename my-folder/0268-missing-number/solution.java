class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sumOfNum = (n *(n + 1))/2;
        int sumNums = 0;
        for (int num : nums) {
            sumNums += num;
        }

        return sumOfNum-sumNums;
    }
}
