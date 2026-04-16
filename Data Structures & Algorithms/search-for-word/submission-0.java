class Solution {
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        int index = 0;
        if(word.length() > n*m);

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == word.charAt(0)){
                    if(check(i,j, word, board,0)) return true;
                }
            }
        }

        return false;
    }

    public boolean check(int i , int j, String word, char[][] board, int index){
        if(index == word.length()) return true;

        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length){
            return false;
        }

        if(board[i][j] == word.charAt(index)){
            char temp = board[i][j];
            board[i][j] = '#';

            boolean down = check(i + 1, j, word, board,index+1);
            boolean up = check(i - 1,j, word,board,index+1);
            boolean right = check(i,j + 1, word,board,index+1);
            boolean left = check(i, j - 1, word, board, index+1);

            board[i][j] = temp;

            return down || up || right || left;
        }

        return false;        
    }
}
