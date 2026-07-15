class Solution {
    private final int MODULO = 1000000007;;
    public int minimumCost(int[] nums, int k) {
        // for each element
        // 1. while nums[i] > k, do operation
        // 2. deduct k with nums[i]
        long currCost = 1;
        long totalCost = 0;
        long currK = k;
        for (int n : nums) {
            if (n > currK) {
                long minAdditionalResourceNeeded = n-currK;
                long numOfOpsNeeded = (minAdditionalResourceNeeded + k - 1)/k;
                long actualAdditionalResource = numOfOpsNeeded * k;
                currK += actualAdditionalResource;

                // arithmetic progression sum: (n * (first + last))/2
                long firstTerm = currCost;
                long lastTerm = currCost + numOfOpsNeeded - 1;
                long sumOfTerms = firstTerm + lastTerm;
                
                long costSum = 0;

                if (numOfOpsNeeded % 2 == 0) {
                    long part1 = (numOfOpsNeeded / 2) % MODULO;
                    long part2 = sumOfTerms % MODULO;
                    costSum = (part1 * part2) % MODULO;
                } else {
                    long part1 = numOfOpsNeeded % MODULO;
                    long part2 = (sumOfTerms / 2) % MODULO;
                    costSum = (part1 * part2) % MODULO;
                }
                totalCost = (totalCost + costSum) % MODULO;
                currCost += numOfOpsNeeded;
            }

            currK -= n;
        }

        return (int) totalCost;
    }
}
