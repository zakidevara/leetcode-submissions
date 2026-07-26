class Solution {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        Map<String, List<Visit>> groupByUser = new HashMap<>();
        
        int n = username.length;
        for (int i = 0; i < n; i++) {
            groupByUser.computeIfAbsent(username[i], key -> new ArrayList<>()).add(new Visit(username[i], timestamp[i], website[i]));
        }
        
        
        
        Map<String, Integer> patternCounter = new HashMap<>();
        int maxCount = 0;
        String bestPattern = "";
        TreeMap<Integer, List<String>> countToPattern = new TreeMap<>(Collections.reverseOrder());
        for (Map.Entry<String, List<Visit>> entry : groupByUser.entrySet()) {
            Collections.sort(entry.getValue(), (a,b) -> Integer.compare(a.timestamp, b.timestamp));
            
            Set<String> uniquePatternsForUser = new HashSet<>();
            List<Visit> visitList = entry.getValue();
            for (int i = 0; i < visitList.size(); i++) {
                for (int j = i + 1; j < visitList.size(); j++) {
                    for (int k = j + 1; k < visitList.size(); k++) {
                        String key = visitList.get(i).website + " " + visitList.get(j).website + " " + visitList.get(k).website;
                        uniquePatternsForUser.add(key);
                    }
                }
            }
            
            for (String pattern : uniquePatternsForUser) {
                int count = patternCounter.getOrDefault(pattern, 0) + 1;
                patternCounter.put(pattern, count);
                
                if (count > maxCount) {
                    maxCount = count;
                    bestPattern = pattern;
                } else if (count == maxCount && pattern.compareTo(bestPattern) < 0) {
                    bestPattern = pattern;
                }
            }
        }
        
        return Arrays.asList(bestPattern.split(" "));
        
    }
    
    private class Visit {
        String username;
        int timestamp;
        String website;
        
        public Visit(String username, int timestamp, String website) {
            this.username = username;
            this.timestamp = timestamp;
            this.website = website;
        }
        
        public String toString() {
            return username + "-" + timestamp + "-" + website;
        }
    }
}
