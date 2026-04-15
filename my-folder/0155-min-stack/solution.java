class MinStack {

    private List<Integer> stack = new ArrayList<>(); // store min val of each push step interweavingly

    public MinStack() {
        
    }
    
    public void push(int val) {
       stack.add(val);
       if (stack.size() == 1) {
        stack.add(val); // add itself as min val
       } else {
        int prevMinVal = stack.get(stack.size() - 2);
        if (val < prevMinVal) {
            stack.add(val);
        } else {
            stack.add(prevMinVal);
        }
       }
    }
    
    public void pop() {
        // remove the min val item & top stack item
        stack.remove(stack.size()-1); // min val
        stack.remove(stack.size()-1); // top stack
    }
    
    public int top() {
        return stack.get(stack.size()-2);
    }
    
    public int getMin() {
        return stack.getLast();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
