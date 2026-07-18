class Solution {
    public int[][] highFive(int[][] items) {
        Map<Integer, PriorityQueue<Integer>> studentTopScores = new TreeMap<>();
        
        for (int[] item : items) {
            PriorityQueue<Integer> pq = studentTopScores.computeIfAbsent(item[0], k -> new PriorityQueue<>());
            pq.offer(item[1]);
            if (pq.size() > 5) {
                pq.poll();
            } 
        }
        
        int[][] result = new int[studentTopScores.keySet().size()][2];
        int i = 0;
        for (Map.Entry<Integer, PriorityQueue<Integer>> entry : studentTopScores.entrySet()) {
            result[i][0] = entry.getKey();
            
            int avg = 0;
            while (!entry.getValue().isEmpty()) {
                avg += entry.getValue().poll();
            }
            
            result[i][1] = avg / 5;
            i++;
        }
        
        return result;
    }
}
