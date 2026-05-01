class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        List<int[]> pos = new ArrayList<>();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(matrix[i][j] == 0) pos.add(new int[]{i, j});
            }
        }

        for(int[] ele : pos){
            int row = ele[0];
            int col = ele[1];

            for(int i = 0; i < n; i++){
                matrix[i][col] = 0;
            }

            for(int i = 0; i < m; i++){
                matrix[row][i] = 0;
            }
        }
    }
}
