class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int len = n * m;

        List<Integer> spiral = new ArrayList<>();
        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = m - 1;

        while(top <= bottom && left <= right){
            
            for(int i = left; i <= right; i++){
                spiral.add(matrix[top][i]);
            }

            top++;

            for(int i = top; i <= bottom; i++){
                spiral.add(matrix[i][right]);
            }
            right--;

            if(top <= bottom){
                for(int i = right; i >= left; i--){
                    spiral.add(matrix[bottom][i]);
                }
                bottom--;
            }
            

            if(left <= right){
                for(int i = bottom; i >= top; i--){
                    spiral.add(matrix[i][left]);
                }
                left++;
            }

        }
        return spiral;
    }
}
