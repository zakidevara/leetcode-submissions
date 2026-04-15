class Solution {
    public boolean isValid(String s) {
        Stack<Character> findStack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            Character complement = getComplementBracket(currChar);
            if (complement != null) {
                findStack.push(complement);
            } else if (findStack.isEmpty()) {
                return false;
            } else {
                Character target = findStack.pop();
                if (!target.equals(currChar)) return false;
            }
        }

        return findStack.isEmpty();
    }

    private Character getComplementBracket(Character c) {
        switch (c) {
            case '(': return ')';
            case '{': return '}';
            case '[': return ']';
        }
        return null;
    }
}
