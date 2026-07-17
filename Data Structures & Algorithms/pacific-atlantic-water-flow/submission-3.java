class Solution {
    int ROWS;
    int COLS;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        ROWS = heights.length;
        COLS = heights[0].length;
        boolean[][] pac = new boolean[ROWS][COLS];
        boolean[][] atl = new boolean[ROWS][COLS];

        for(int c = 0; c < COLS; c++){
            dfs(0, c, pac, heights[0][c], heights);
            dfs(ROWS - 1, c, atl, heights[ROWS - 1][c], heights);
        }

        for(int r = 0; r < ROWS; r++){
            dfs(r, 0, pac, heights[r][0], heights);
            dfs(r, COLS - 1, atl, heights[r][COLS - 1], heights);
        }

        for(int r = 0; r < ROWS; r++){
            for(int c = 0; c < COLS; c++){
                if(pac[r][c] && atl[r][c]){
                    res.add(List.of(r, c));
                }
            }
        }

        return res;
    }

    private void dfs(int r, int c, boolean[][] visit, int prevHeight, int[][] heights){
        if (r < 0 || c < 0 || r == ROWS || c == COLS || visit[r][c] || heights[r][c] < prevHeight){
            return;
        }

        visit[r][c] = true;
        dfs(r + 1, c, visit, heights[r][c], heights);
        dfs(r - 1, c, visit, heights[r][c], heights);
        dfs(r, c + 1, visit, heights[r][c], heights);
        dfs(r, c - 1, visit, heights[r][c], heights);
    }
}
