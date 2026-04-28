class Solution {
    public int minimumOperations(int[] nums) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        for (int n : nums) {
            if (n != 0) {
                uniqueNumbers.add(n);
            }
        }

        return uniqueNumbers.size();
    }
}
