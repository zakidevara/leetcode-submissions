public class LogSystem {
    private final TreeMap<String, List<Integer>> logs;
    private final Map<String, Integer> granularityLengths;
    
    private final String MIN_TIME = "2000:01:01:00:00:00";
    private final String MAX_TIME = "2017:12:31:23:59:59";

    public LogSystem() {
        this.logs = new TreeMap<>();
        this.granularityLengths = new HashMap<>();
        
        granularityLengths.put("Year", 4);
        granularityLengths.put("Month", 7);
        granularityLengths.put("Day", 10);
        granularityLengths.put("Hour", 13);
        granularityLengths.put("Minute", 16);
        granularityLengths.put("Second", 19);
    }

    // O(log n) time
    public void put(int id, String timestamp) {
        logs.computeIfAbsent(timestamp, k -> new ArrayList<>()).add(id);
    }

    // O(log n) time to find bounds + O(k) to collect results
    public List<Integer> retrieve(String start, String end, String granularity) {
        int len = granularityLengths.get(granularity);

        String startBound = start.substring(0, len) + MIN_TIME.substring(len);
        String endBound = end.substring(0, len) + MAX_TIME.substring(len);

        List<Integer> result = new ArrayList<>();
        
        for (List<Integer> ids : logs.subMap(startBound, true, endBound, true).values()) {
            result.addAll(ids);
        }

        return result;
    }
}
