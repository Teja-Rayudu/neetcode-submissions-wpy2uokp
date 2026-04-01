class MinStack {
    Stack<Integer> st;
    Stack<Integer> min;
    public MinStack() {
        st = new Stack<>();
        min = new Stack<>();
    }
    
    public void push(int val) {
        st.push(val);
        if(min.isEmpty() || val <= min.peek()) min.push(val);
    }
    
    public void pop() {
        if(st.isEmpty()) return;
        int top = st.pop();
        if(top == min.peek()){
            min.pop();
        }
    }
    
    public int top() {
        if(st.isEmpty()) return -1;
        return st.peek();
    }
    
    public int getMin() {
        if(!min.isEmpty()) return min.peek();
        return -1;
    }
}
