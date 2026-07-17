class Solution {
    private final long MODULO = 1000000007L;
    public int divisibleGame(int[] nums) {
        long maxDiff = Long.MIN_VALUE;
        
        int maxLeft = 0;
        int maxRight = nums.length;
        long maxK = 2;

        long maxNum = nums[0];
        long minNum = Long.MAX_VALUE;
        int[] prefixSum = new int[nums.length+1];
        for (int i = 1; i <= nums.length; i++) {
            prefixSum[i] = prefixSum[i-1] + nums[i-1];
            maxNum = Math.max(maxNum, nums[i-1]);
            minNum = Math.min(minNum, nums[i-1]);
        }
        
        if (maxNum < 2) {
            maxDiff = -nums[0] % MODULO;
        }

        Map<Integer, List<Integer>> multiples = new HashMap<>();
        Map<Integer, List<Integer>> divisorsCache = new HashMap<>(); // Cache for duplicate numbers
        
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (!divisorsCache.containsKey(n)) {
                List<Integer> divs = new ArrayList<>();
                for (int d = 1; d * d <= n; d++) {
                    if (n % d == 0) {
                        if (d >= 2) divs.add(d);
                        int d2 = n / d;
                        if (d2 != d && d2 >= 2) divs.add(d2);
                    }
                }
                divisorsCache.put(n, divs);
            }
            
            for (int d : divisorsCache.get(n)) {
                multiples.computeIfAbsent(d, x -> new ArrayList<>()).add(i);
            }
        }
        
        // We only need to check K's that are actual divisors of elements in the array
        List<Integer> validKs = new ArrayList<>(multiples.keySet());
        for (int k = 2; k < maxNum; k++) {
            if (!multiples.containsKey(k)) {
                validKs.add(k); // missing k representative, because all the missing k will result in the same score diff: -sum
                break;
            }
        }

        Collections.sort(validKs);
        
        for (int k : validKs) {
            if (k > maxNum) break;
            long maxDiffForK = Long.MIN_VALUE;
            int lastIndex = -1;
            
            if (!multiples.containsKey(k) || k < 2) {
                maxDiffForK = -minNum;
            } else {
                List<Integer> indexes = multiples.computeIfAbsent(k, key -> new ArrayList<>());
                long currScoreDiff = 0;
                for (int idx : indexes) {
                    if (lastIndex != -1) {
                        int gap = prefixSum[idx] - prefixSum[lastIndex+1];
                        currScoreDiff -= gap;
                    }
    
                    if (currScoreDiff < 0) {
                        currScoreDiff = 0;
                    }
                    
                    currScoreDiff += nums[idx];
    
                    
                    if (maxDiffForK < currScoreDiff) {
                        maxDiffForK = currScoreDiff;
                    }
                    
                    lastIndex = idx;
                }
            }
            
        
            if (maxDiffForK > maxDiff) {
                maxDiff = maxDiffForK;
                maxK = k;
            }
            
        }

        return (int) (((maxDiff % MODULO + MODULO) * (maxK % MODULO + MODULO)) % MODULO);
    }
}
