class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        
        for(int i = 0; i < m; i++){
            Arrays.fill(dp[i], -1);
        }
        
        return dfs(0, 0, m, n, dp);
    }

    private int dfs(int r, int c, int m, int n, int[][] dp) {
        
        if (r >= m || c >= n) {
            return 0;
        }

        
        if (r == m - 1 && c == n - 1) {
            return 1;
        }

        
        if (dp[r][c] != -1) {
            return dp[r][c];
        }

        dp[r][c] = dfs(r + 1, c, m, n, dp) + dfs(r, c + 1, m, n, dp);
        
        return dp[r][c];
    }
}