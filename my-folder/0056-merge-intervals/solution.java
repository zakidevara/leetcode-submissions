class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            int primaryCompare = Integer.compare(a[0], b[0]);
            if (primaryCompare != 0) {
                return primaryCompare;
            }
            return Integer.compare(a[1], b[1]); // Tie-breaker column
        });

        int[][] res = new int[intervals.length][2];
        int i = 0;
        int left = 0;
        int right = 1;
        int maxRightBound = intervals[0][1];
        while (right < intervals.length) {
            if (maxRightBound < intervals[right][0]) {
                // chain ends here;
                res[i][0] = intervals[left][0];
                res[i][1] = maxRightBound;
                i++;
                left = right;
            }
            right++;
            maxRightBound = Math.max(intervals[right-1][1], maxRightBound);
        }
        
        res[i][0] = intervals[left][0];
        res[i][1] = maxRightBound;
        i++;


        return Arrays.copyOf(res, i);
    }
}
