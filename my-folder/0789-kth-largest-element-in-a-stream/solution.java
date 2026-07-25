class KthLargest {
    private int k;
    private PriorityQueue<Integer> pq;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.pq = new PriorityQueue<>((a,b) -> a - b);
        for (int n : nums) {
            add(n);
        }


    }
    
    public int add(int val) {
        if (pq.size() >= k) {
            if (val < pq.peek()) {
                return pq.peek();
            }

            pq.poll();
        }

        pq.offer(val);

        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
