class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>(); // stack of indices
        int[] answer = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            // monotonic decreasing (bottom to top)
            while (!stack.empty() && temperatures[i] > temperatures[stack.peek()]) {
                int popValue = stack.pop();
                answer[popValue] = i - popValue;
            }
            stack.push(i);
        }

        return answer;
    }
}
