class Solution {
    public boolean[] transformStr(String s, String[] strs) {
        int[] sZeroPref = new int[s.length()+1];
        int[] sOnePref = new int[s.length()+1];
        int[] counter = new int[2];

        for (int i = 1; i <= s.length(); i++) {
            if (s.charAt(i-1) == '0') {
                sZeroPref[i] = sZeroPref[i-1] + 1;
                sOnePref[i] = sOnePref[i-1];
                counter[0]++;
            } else {
                sZeroPref[i] = sZeroPref[i-1];
                sOnePref[i] = sOnePref[i-1] + 1;
                counter[1]++;
            }
        }

        boolean[] result = new boolean[strs.length];
        int j = 0;
        for (String t : strs) {
            int[] tZeroPref = new int[t.length()+1];
            int[] tOnePref = new int[t.length()+1];
            int[] tCounter = new int[2];

            int existingZeros = 0;
            for (int i = 0; i < t.length(); i++) {
                if (t.charAt(i) == '0') {
                    existingZeros++;
                }
            }

            int zerosNeeded = counter[0] - existingZeros;
            
            if (zerosNeeded < 0) {
                result[j++] = false;
                continue;
            }

            result[j] = true;
            for (int i = 1; i <= t.length(); i++) {
                Character curr = t.charAt(i-1);
                if (curr == '?') {
                    if (existingZeros < counter[0]) {
                        curr = '0';
                        existingZeros++;
                    } else {
                        curr = '1';
                    }
                }
                
                if (curr == '0') {
                    tZeroPref[i] = tZeroPref[i-1] + 1;
                    tOnePref[i] = tOnePref[i-1];
                    tCounter[0]++;
                } else {
                    tZeroPref[i] = tZeroPref[i-1];
                    tOnePref[i] = tOnePref[i-1] + 1;
                    tCounter[1]++;
                }

                if (tOnePref[i] > sOnePref[i] || sZeroPref[i] > tZeroPref[i] || tCounter[0] > counter[0] || tCounter[1] > counter[1]) {
                    result[j] = false;
                    break;
                }
            }
            j++;
        }

        return result;
    }
}
