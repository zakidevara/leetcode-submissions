class HitCounter {
    private Queue<Integer> hits = new ArrayDeque<>();
    public HitCounter() {
        
    }
    
    public void hit(int timestamp) {
        hits.offer(timestamp);
    }
    
    public int getHits(int timestamp) {
        while (!hits.isEmpty() && hits.peek() <= timestamp-300) {
            hits.poll();
        }

        return hits.size();
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */
