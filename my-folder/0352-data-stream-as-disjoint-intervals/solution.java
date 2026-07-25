class SummaryRanges {
    private TreeSet<Integer> stream;

    public SummaryRanges() {
        stream = new TreeSet<>();
    }
    
    public void addNum(int value) {
        stream.add(value);
    }
    
    public int[][] getIntervals() {
        if (stream.size() == 0) return new int[0][0]; 
        int[][] res = new int[stream.size()][2];
        int left = stream.getFirst();
        int right = stream.getFirst();

        int count = 0;
        for (int i : stream) {
            if (i-right <= 1) {
                right = i;
            } else {
                res[count][0] = left;
                res[count][1] = right;
                left = i;
                right = i;
                count++;
            }
        }
        res[count][0] = left;
        res[count][1] = right;

        return Arrays.copyOf(res, count+1);
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(value);
 * int[][] param_2 = obj.getIntervals();
 */
