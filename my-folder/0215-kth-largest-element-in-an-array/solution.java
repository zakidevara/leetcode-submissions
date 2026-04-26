class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int n : nums) {
            if (minHeap.size() < k) {
                minHeap.add(n);
            } else if (minHeap.peek() < n) {
                minHeap.poll();
                minHeap.add(n);
            }
        }

        return minHeap.peek();
    }
}
