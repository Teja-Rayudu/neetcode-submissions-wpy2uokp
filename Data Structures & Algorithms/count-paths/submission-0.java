class Solution {
    int ROWS;
    int COLS;
    public int uniquePaths(int m, int n) {
        boolean[][] visited = new boolean[m][n];
        int[] paths = {0};
        ROWS = m;
        COLS = n;
        dfs(0,0,visited, paths);
        return paths[0];
    }

    public void dfs(int r, int c, boolean[][] visi, int[] paths){
        if(r == ROWS - 1 && c == COLS - 1){
            paths[0] += 1;
            return;
        }

        if(r >= ROWS || c >= COLS ) return;

        if(!visi[r][c]){
            visi[r][c] = true;
            dfs(r + 1, c, visi, paths);
            dfs(r, c + 1, visi, paths);
            visi[r][c] = false;
        }
    }
}
