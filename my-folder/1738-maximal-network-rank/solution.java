class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        if (roads.length == 0) return 0;
        Map<Integer, Set<Integer>> adjacencyMap = new HashMap<>();

        for (int[] road : roads) {
            adjacencyMap.computeIfAbsent(road[0], k -> new HashSet<>()).add(road[1]);
            adjacencyMap.computeIfAbsent(road[1], k -> new HashSet<>()).add(road[0]);
        }

        Map.Entry<Integer, Set<Integer>>[] sortedEntries = adjacencyMap.entrySet()
            .stream()
            .sorted(Map.Entry.<Integer, Set<Integer>>comparingByValue(Comparator.comparingInt(Set::size)).reversed())
            .toArray(Map.Entry[]::new);

        int maxRank = 0;
        int maxFreq = sortedEntries[0].getValue().size();
        int secondMaxFreq = Arrays.stream(sortedEntries)
            .filter(v -> v.getValue().size() < maxFreq)
            .findFirst()
            .orElseGet(()-> Map.entry(0, Set.of()))
            .getValue().size();
        for (Map.Entry<Integer, Set<Integer>> e1 : sortedEntries) {
            if (e1.getValue().size() < secondMaxFreq) break;
            for (Map.Entry<Integer, Set<Integer>> e2 : sortedEntries) {
                if (e2.getValue().size() < secondMaxFreq) break;
                if (e2.getKey() == e1.getKey()) continue;

                int currRank = e1.getValue().size() + e2.getValue().size();
                
                if (e1.getValue().contains(e2.getKey())) currRank--;
                if (currRank > maxRank) maxRank = currRank;
            }
            
        }

        return maxRank;
    }
}
