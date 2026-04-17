class Trie{
    Trie[] children;
    boolean isEnd;
    public Trie(){
        children = new Trie[26];
        isEnd = false;
    }

    public void addWord(String word){
        Trie curr = this;
        for(char c : word.toCharArray()){
            int index = c - 'a';
            if(curr.children[index] == null){
                curr.children[index] = new Trie();
            }
            curr = curr.children[index];
        }

        curr.isEnd = true;
    }
}

class Solution {
    private int rows;
    private int cols;
    public List<String> findWords(char[][] board, String[] words) {
        Trie root = new Trie();

        for(String s : words){
            root.addWord(s);
        }

        rows = board.length;
        cols = board[0].length;
        List<String> res = new ArrayList<>();

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                dfs(i, j, root, new StringBuilder(),res, board);
            }
        }

        return res;
    }

    private void dfs(int i, int j, Trie root, StringBuilder sb,List<String> res, char[][] board){
        if(i < 0 || i >= rows || j < 0 || j >= cols || board[i][j] == '*'){
            return;
        }

        char c = board[i][j];
        int index = c - 'a';

        if(root.children[index] == null) return;

        root = root.children[index];
        sb.append(c);

        if(root.isEnd){
            res.add(sb.toString());
            root.isEnd = false;
        }

        board[i][j] = '*';

        dfs(i - 1,j, root, sb, res, board);
        dfs(i + 1,j, root, sb, res, board);
        dfs(i,j - 1, root, sb, res, board);
        dfs(i,j + 1, root, sb, res, board);

        board[i][j] = c;

        sb.deleteCharAt(sb.length() - 1);

    }
}
