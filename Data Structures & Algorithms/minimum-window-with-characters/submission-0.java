class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        String minString = "";
        int minLen = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            for(int j = i ; j < n; j++){
                String s1 = s.substring(i, j + 1);
                if(check(s1, t) && s1.length() < minLen){
                    minString = s1;
                    minLen = minString.length();
                }
            }
        }

        return minString;
    }

    private boolean check(String s, String t){
        if(t.length() > s.length()) return false;
        int[] charCount = new int[128];

        for(char c : t.toCharArray()){
            charCount[c]++;
        }

        for(char c : s.toCharArray()){
            charCount[c]--;
        }

        for(int count : charCount){
            if(count > 0) return false;
        }

        return true;
    }
}
