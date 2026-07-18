class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> brackets = Map.of(
            '(', ')',
            '[', ']',
            '{', '}'
        );
        for (Character c : s.toCharArray()) {
            if (brackets.containsKey(c)) {
                stack.push(brackets.get(c));
            } else if (!stack.isEmpty() && c == stack.peek()) {
                stack.pop();
            } else {
                return false;
            }
        }
        
        return stack.isEmpty();
    }
    
}
