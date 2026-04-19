class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        
        for (int i = 1; i <= s.length(); i++) {
            for (String word : wordDict) {
                int wordLen = word.length();
                // Check if the word can fit ending at index i
                if (i >= wordLen) {
                    // If the prefix before it is valid AND the string matches the word
                    if (dp[i - wordLen] && s.substring(i - wordLen, i).equals(word)) {
                        dp[i] = true;
                        break; // Found a valid way to form s up to i, move to next i
                    }
                }
            }
        }
        
        return dp[s.length()];
    }
}