class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            if(Character.isLetter(c) || Character.isDigit(c)) sb.append(c);
        }
        int len =  sb.toString().length();

        int left = 0;
        int right = len - 1;

        while(left < right){
            if(sb.charAt(left) != sb.charAt(right)) return false;
            left++;
            right--;
        }

        return true;
    }
}
