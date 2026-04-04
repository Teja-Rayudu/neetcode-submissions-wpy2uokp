class Solution {
    
    public int countSubstrings(String s) {
        int n = s.length();
        int count = 0;
        
        for(int i = 0; i < n; i++){
            int odd = expandCenter(s, i, i);
            int even = expandCenter(s, i, i + 1);
            
            count+= odd + even;
        }
        
        return count;
    }
    
    private int expandCenter(String str, int left, int right){
        int count = 0;
        while(left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)){
            count++;
            left--;
            right++;
        }
        return count;
    }
}
