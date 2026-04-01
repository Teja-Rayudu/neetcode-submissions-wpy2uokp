class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for(String c : tokens){
            if(isOperator(c)){
                st.push(Integer.parseInt(c));
            }
            else{
                int b = st.pop();
                int a = st.pop();
                if(c.equals("+")) st.push(a + b);
                else if(c.equals("-")) st.push(a - b);
                else if(c.equals("*")) st.push(a * b);
                else if(c.equals("/")) st.push(a / b);
            }
        }
        return st.peek();
    }

    public boolean isOperator(String c){
        if(c.equals("+") || c.equals("*") || c.equals("/") || c.equals("-")){
            return false;
        }
        return true;
    }
}
