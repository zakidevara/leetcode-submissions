class Solution {
    public int countCharacters(String[] words, String chars) {
        int result = 0;
        Map<Character, Integer> charCountMap = new HashMap<>();
        for (int i = 0; i < chars.length(); i++) {
            Character currentChar = chars.charAt(i);
            if (charCountMap.get(currentChar) == null) {
                charCountMap.put(currentChar, 1);
            } else {
                charCountMap.put(currentChar, charCountMap.get(currentChar) + 1);
            }
        }
        
        for (int i = 0; i < words.length; i++) {
            Map<Character, Integer> tempCharCountMap = new HashMap(charCountMap);
            String currentWord = words[i];
            boolean good = true;
            for (int j = 0; j < currentWord.length(); j++) {
                Character letter = currentWord.charAt(j);
                if (tempCharCountMap.get(letter) != null) {
                    tempCharCountMap.put(letter, tempCharCountMap.get(letter) - 1);
                    if (tempCharCountMap.get(letter) < 0) {
                        good = false;
                        continue;
                    }
                } else {
                    good = false;
                    continue;
                }
            }
            if (good) {
                result += currentWord.length();
            }
        }
        
        return result;
    }
}
