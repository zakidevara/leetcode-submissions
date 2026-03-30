class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Integer> counter = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            counter.put(s.charAt(i), counter.computeIfAbsent(s.charAt(i), k -> 0) + 1);
            counter.put(t.charAt(i), counter.computeIfAbsent(t.charAt(i), k -> 0) - 1);
        }

        return !counter.values().stream().anyMatch(v -> v > 0);
    }
}
