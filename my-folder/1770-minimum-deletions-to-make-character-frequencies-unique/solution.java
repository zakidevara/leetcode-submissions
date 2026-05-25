class Solution {
    public int minDeletions(String s) {
        Integer[] counter = new Integer[26];
        Arrays.fill(counter, 0);

        for (Character c : s.toCharArray()) {
            counter[(int) c % 97]++;
        }

        Arrays.sort(counter, Collections.reverseOrder());

    

        int deletion = 0;
        for (int i = 1; i < 26; i++) {
            if (counter[i] == 0) break;
            
            if (counter[i] >= counter[i - 1]) {
                int next = counter[i];
                counter[i] = Math.max(0, counter[i - 1] - 1);
                deletion += next - counter[i]; 
            }
        }
        return deletion;
    }
}
