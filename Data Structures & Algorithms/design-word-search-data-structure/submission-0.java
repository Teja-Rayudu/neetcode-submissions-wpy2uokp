class WordDictionary {
    WordDictionary[] childs;
    boolean isEnd;
    WordDictionary root = null;

    public WordDictionary() {
        childs = new WordDictionary[26];
        isEnd = false;
    }

    public void addWord(String word) {
        if(root == null) root = new WordDictionary();
        WordDictionary curr = root;
        for(char c : word.toCharArray()){
            if(curr.childs[c - 'a'] == null){
                curr.childs[c - 'a'] = new WordDictionary();
            }

            curr = curr.childs[c - 'a'];
        }

        curr.isEnd = true;
    }

    public boolean search(String word) {
        if(root == null) return false;
       return dfs(word, 0,root);
    }

    private boolean dfs(String word, int j, WordDictionary node){
        WordDictionary curr = node;
        for(int i = j; i < word.length(); i++){
            char c = word.charAt(i);
            if(c == '.'){
                for(WordDictionary child : curr.childs){
                    if(child != null && dfs(word, i + 1, child)) return true;
                }
                return false;
            }
            else{
                if(curr.childs[c - 'a'] == null) return false;
                curr = curr.childs[c - 'a'];
            }
        }
           
        return curr.isEnd;
    }
}
