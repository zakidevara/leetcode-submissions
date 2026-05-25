class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>(); // monotonic stack descending order (bottom -> top)
        int[] result = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int curr = stack.pop();
                result[curr] = i-curr;
            }

            stack.push(i);
        }


        return result;
    }
}
