class Solution {
    public int getMaxLen(int[] nums) {
        Queue<Integer> zeroesIndex = new LinkedList<>();

        zeroesIndex.offer(-1);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) zeroesIndex.add(i); 
        }
        zeroesIndex.offer(nums.length);

        int maxLength = 0;
        int prevIdx = zeroesIndex.poll();
        while(!zeroesIndex.isEmpty() || prevIdx < nums.length) {
            int idx = zeroesIndex.poll();

            int negativeFreq = 0;
            int currLength = idx - prevIdx - 1;
            int firstNegative = -1;
            int lastNegative = -1;
            for (int i = prevIdx + 1; i < idx; i++) {
                if (nums[i] < 0) {
                    if (firstNegative == -1) {
                        firstNegative = i;
                    }
                    lastNegative = i;
                    negativeFreq++;
                }
            }

            if (negativeFreq % 2 == 0) {
                if (maxLength < currLength) maxLength = currLength;
            } else {
                int currMaxLength = Math.max(idx - 1 - firstNegative, lastNegative - prevIdx - 1);
                if (maxLength < currMaxLength) maxLength = currMaxLength;
            }
            
            prevIdx = idx;
        }

        return maxLength;
    }
}

// 1, 0, 3, 2, 0, 4, 5, 0, 2, -2, -3, 4, 0, 3, -1, -1, -1, 4

// -1 1 4 7 12 18

// 1
// 3 2
// 4 5
// 2 -2 -3 4
// 3 -1 -1 4 -1 0


