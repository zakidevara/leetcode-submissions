class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();

        int result = 0;
        int currNum = 0;
        int sign = 1;
        for (int i = 0; i < s.length(); i++) {
            Character curr = s.charAt(i);

            if (Character.isDigit(curr)) {
                currNum = currNum * 10 + (curr - '0'); // append digit to curr num
            } else if (curr == '+') {
                result += currNum * sign; // add prev num to result with the sign, then set sign to plus & reset currNum
                sign = 1;
                currNum = 0;
            } else if (curr == '-') {
                result += currNum * sign; // add prev num with the sign, then set sign to negative & reset currNum
                sign = -1;
                currNum = 0;
            } else if (curr == '(') {
                stack.push(result); // push outer result to stack with its sign
                stack.push(sign);
                result = 0; // reset all variables, these will be used to calculate the inner parantheses expression
                sign = 1;
                currNum = 0;
            } else if (curr == ')') {
                result += currNum * sign; // finish up inner paranthesis calculation
                currNum = 0;
                result *= stack.pop(); // multiply with prev sign
                result += stack.pop(); // 
            }
        }

        return result += sign * currNum;
    }
}
