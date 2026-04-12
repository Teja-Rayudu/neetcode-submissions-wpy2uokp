class PrefixTree {
    PrefixTree[] chars;
    boolean isEndOfWord;
    PrefixTree root = null;


    public PrefixTree() {
        chars = new PrefixTree[26];
        isEndOfWord = false;
    }

    public void insert(String word) {
        if(root == null) root = new PrefixTree();
        PrefixTree curr = root;
        for(char c : word.toCharArray()){
            if(curr.chars[c - 'a'] == null){
                curr.chars[c - 'a'] = new PrefixTree();
            }
            curr = curr.chars[c - 'a'];
        }
        curr.isEndOfWord = true;
    }

    public boolean search(String word) {
        if(root == null) return false;
        PrefixTree curr = root;
        for(char c : word.toCharArray()){
            if(curr.chars[c - 'a'] == null) return false;
            curr = curr.chars[c - 'a'];
        }

        return curr.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        if(root == null) return false;
        PrefixTree curr = root;
        for(char c : prefix.toCharArray()){
            int index = c - 'a';
            if(curr.chars[index] == null) return false;
            curr = curr.chars[index];
        }

        return true;
    }
}
