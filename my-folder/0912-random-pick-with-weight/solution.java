class Solution {
    private int[] prefixSum;
    private int totalSum;

    public Solution(int[] w) {
        prefixSum = new int[w.length];
        prefixSum[0] = w[0];
        for (int i = 1; i < w.length; i++) {
            prefixSum[i] = prefixSum[i-1] + w[i];
        }

        totalSum = prefixSum[w.length-1];
    }
    
    public int pickIndex() {
        Random random = new Random();
        int target = random.nextInt(totalSum) + 1; // range between [1, totalSum]
        int left = 0;
        int right = prefixSum.length-1;

        while (left < right) {
            int mid = left + (right-left) / 2;
            if (target > prefixSum[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    } 
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
