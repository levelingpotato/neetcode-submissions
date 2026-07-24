class MinStack {
    Deque<int[]> minStack;




    public MinStack() {
        this.minStack = new ArrayDeque<>();
    }
    
    public void push(int val) {
        if(minStack.isEmpty() || val <= minStack.peek()[1]){
            minStack.push(new int[]{val, val});
        } else if(val > minStack.peek()[1]){
            minStack.push(new int[]{val, minStack.peek()[1]});
        }
    }
    
    public void pop() {
        minStack.pop();
    }
    
    public int top() {
        return minStack.peek()[0];
    }
    
    public int getMin() {
        return minStack.peek()[1];
    }
}
