class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        
        for (String s : strs) {
            
            int[] counter = new int[26];
            
            for (Character c : s.toCharArray()) {
                counter[c - 'a']++;
            }
            
            map.computeIfAbsent(Arrays.toString(counter), k -> new ArrayList<>()).add(s);
        }
        
        map.forEach((key, value) -> System.out.println(key + " = " + value));
        
        
        List<List<String>> result = new ArrayList<>();
        for (List<String> v : map.values()) {
            result.add(v);
        }
        return result;
    }
}
