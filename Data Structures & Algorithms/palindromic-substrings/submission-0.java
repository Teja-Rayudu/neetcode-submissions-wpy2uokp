class Solution {
    int count = 0;
    public int countSubstrings(String s) {
        if(s.length() == 1) return 1;
        for(int i = 0; i < s.length(); i++){
            for(int j = i + 1; j < s.length() + 1; j++){
                String str = s.substring(i, j);
                if(palindrome(str)) count++;
            }
        }
        return count;
    }
    
    private boolean palindrome(String str){
        if(str.length() == 1) return true;
        int i = 0;
        int j = str.length() - 1;
        while(i <= j){
            if(str.charAt(i) != str.charAt(j)) return false;
            i++;
            j--;
        }

        return true;
    }
}
