class Solution {
    public List<List<Integer>> aggregateTimeSeries(int[][] series1, int[][] series2) {
        List<List<Integer>> result = new ArrayList<>();

        int p1 = 0;
        int p2 = 0;
        while (p1 < series1.length || p2 < series2.length) {
            int p1Timestamp = p1 >= series1.length ? series2[p2][0] : series1[p1][0];
            int p2Timestamp = p2 >= series2.length ? series1[p1][0] : series2[p2][0];
            int p1Val =  p1 >= series1.length ? 0 : series1[p1][1];
            int p2Val =  p2 >= series2.length ? 0 : series2[p2][1];
            
            int currTimestamp = Math.min(p1Timestamp, p2Timestamp);
            int currSum = p1Val + p2Val;
            result.add(List.of(currTimestamp, currSum));

            if (p1Timestamp < p2Timestamp) {
                p1++;
            } else if (p1Timestamp > p2Timestamp) {
                p2++;
            } else {
                p1++;
                p2++;
            }
        }

        return result;
    }
}
