class Solution {
    private int rows;
    private int cols;
    boolean[][] visited;
    public List<String> findWords(char[][] board, String[] words) {
        rows = board.length;
        cols = board[0].length;

        visited = new boolean[rows][cols];
        List<String> found = new ArrayList<>();

        for(String s : words){
            boolean wordFound = false;
            for(int i = 0; i < rows && !wordFound; i++){
                for(int j = 0; j < cols && !wordFound; j++){
                    if(board[i][j] == s.charAt(0)){
    
                        if(check(i,j,board,s,0)){
                            found.add(s);
                            wordFound = true;
                        }
                        
                    }
                }
            }
        }

        return found;
    }

    private boolean check(int i, int j, char[][] board,String s, int index){
        if(index == s.length()) return true;

        int n = s.length();
        if(i < 0 || i >= rows || j < 0 || j >= cols || visited[i][j] || board[i][j] != s.charAt(index)){
            return false;
        }

        visited[i][j] = true;
        boolean res = check(i - 1,j,board,s,index+1) || check(i + 1,j,board,s,index+1) ||check(i,j - 1,board,s,index+1)||check(i,j + 1,board,s,index+1);
        visited[i][j] = false;
        return res;
    }
}
