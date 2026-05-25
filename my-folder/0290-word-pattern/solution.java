class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (words.length != pattern.length()) return false;

        int n = pattern.length();
        Set<Character> uniqueChar = new HashSet<>();
        Set<String> uniqueWord = new HashSet<>();
        Map<Character, String> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(pattern.charAt(i))) {
                map.put(pattern.charAt(i), words[i]);
            } else if (!map.get(pattern.charAt(i)).equals(words[i])) {
                return false;
            }

            uniqueChar.add(pattern.charAt(i));
            uniqueWord.add(words[i]);
        }

        return uniqueChar.size() == uniqueWord.size();
    }
}
