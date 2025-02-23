class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> counter = new HashMap<>();
        int majorityNumber = nums[0];
        for (int i = 0; i < nums.length; i++) {
            Integer currNumber = Integer.valueOf(nums[i]);
            if (counter.get(currNumber) == null) {
                counter.put(currNumber, 1);
            } else {
                counter.put(currNumber, counter.get(currNumber) + 1);
            }
            if (counter.get(majorityNumber) < counter.get(currNumber)) {
                majorityNumber = currNumber;
            }
        }
        return majorityNumber;
    }
}
