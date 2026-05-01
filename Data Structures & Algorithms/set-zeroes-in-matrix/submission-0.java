class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        boolean[][] zeros = new boolean[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(matrix[i][j] == 0) zeros[i][j] = true;
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(matrix[i][j] == 0 && zeros[i][j]){
                    makeZeros(i, j, n, m, matrix);
                }
            }
        }
    }

    private void makeZeros(int i, int j, int n, int m, int[][] matrix){
       
       for(int r = i; r < n; r++){
        matrix[r][j] = 0;
       }

       for(int r = i; r >= 0; r--){
        matrix[r][j] = 0;
       }

       for(int c = j; c < m; c++){
        matrix[i][c] = 0;
       }

       for(int c = j; c >= 0; c--){
        matrix[i][c] = 0;
       }
    }
}
