class MedianFinder {
    PriorityQueue<Integer> lowerHalf = new PriorityQueue<>(
        (a,b) -> b - a
    ); // max heap

    
    PriorityQueue<Integer> upperHalf = new PriorityQueue<>(
        (a,b) -> a - b
    ); // min heap

    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
         lowerHalf.offer(num); 

        // ensure max of lower <= min of upper
        if (!upperHalf.isEmpty() && lowerHalf.peek() > upperHalf.peek()) {
            upperHalf.offer(lowerHalf.poll());
        }

        // rebalance 
        if (lowerHalf.size() > upperHalf.size() + 1) {
            upperHalf.offer(lowerHalf.poll());
        } else if (upperHalf.size() > lowerHalf.size()) {
            lowerHalf.offer(upperHalf.poll());
        }
    }
    
    public double findMedian() {
        int total = lowerHalf.size() + upperHalf.size();

        if (total % 2 == 0) {
            return ((double) lowerHalf.peek() + (double) upperHalf.peek()) / 2;
        } else {
            return lowerHalf.size() > upperHalf.size() ? lowerHalf.peek() : upperHalf.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
