class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> st = new Stack();
        Stack<Integer> star = new Stack();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='(' ){
                st.push(i);
            }
            else if(c=='*') star.push(i);
            else{
                if(!st.isEmpty()) st.pop();
                else if(!star.isEmpty()) star.pop();
                else return false;
            } 
        }

        while(!st.isEmpty() && !star.isEmpty()){
            if(star.pop()<st.pop()) return false;
        }

        return st.isEmpty();
    }
}