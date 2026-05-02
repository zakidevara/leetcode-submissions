import java.util.Stack;

class Solution {
    private static final int MOD = 1000000007;
    
    public int totalStrength(int[] strength) {
        Stack<Integer> stack = new Stack<>();
        long result = 0;

        // 1. find left and right boundaries (O(n) time)
        int[] left = new int[strength.length];
        int[] right = new int[strength.length];
        
        for(int i = 0; i < strength.length; i++) {
            while (!stack.empty() && strength[stack.peek()] >= strength[i]) {
                stack.pop();
            }
            left[i] = stack.empty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear();
        
        for(int i = strength.length - 1; i >= 0; i--) {
            while (!stack.empty() && strength[stack.peek()] > strength[i]) {
                stack.pop();
            }
            right[i] = stack.empty() ? strength.length : stack.peek();
            stack.push(i);
        }

        // 2. calculate prefix sum (O(n) time)
        long[] prefixSum = new long[strength.length + 1];
        for (int i = 0; i < strength.length; i++) {
            prefixSum[i + 1] = (prefixSum[i] + strength[i]);
        }
        
        long[] doublePrefixSum = new long[strength.length + 2];
        for (int i = 0; i < prefixSum.length; i++) {
            doublePrefixSum[i + 1] = (doublePrefixSum[i] + prefixSum[i]);
        }

        // 3. calculate total strength (O(n) time) 
        for (int i = 0; i < strength.length; i++) {
            long leftItemCount = i - left[i];
            long rightItemCount = right[i] - i;

            // Use (A - B + MOD) % MOD to prevent negative results
            long ppRight = (doublePrefixSum[right[i] + 1] - doublePrefixSum[i + 1]) % MOD; 
            long ppLeft = (doublePrefixSum[i + 1] - doublePrefixSum[left[i] + 1]) % MOD;

            long rightSum = (leftItemCount * ppRight);
            long leftSum = (rightItemCount * ppLeft);
            
            // Apply modulo to the subtraction
            long contrib = (rightSum - leftSum + MOD) % MOD;

            // Apply modulo to the final multiplication before adding to result
            long totalContribution = (strength[i] * contrib) % MOD;
            result = (result + totalContribution) % MOD;
        }

        return (int) result;
    }
}
