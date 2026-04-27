class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if(n == 1) return s;

        int[][] dp = new int[n][n];
        int starting = 0;
        int maxLen = 0;

        for(int i = 0; i < n; i++){
            dp[i][i] = 1;
            maxLen = 1;
        }

        for(int i = 1; i < n; i++){
            if(s.charAt(i - 1) == s.charAt(i)){
                dp[i - 1][i] = 1;
                starting = i - 1;
                maxLen = 2;
            }
        }

        for(int L = 3; L <= n; L++){
            for(int i = 0; i <= n - L; i++){
                int j = i + L - 1;
                if(s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1] == 1){
                    dp[i][j] = 1;
                    starting = i;
                    maxLen = L;
                }
            }
        }

        return s.substring(starting, starting + maxLen);
    }
}
