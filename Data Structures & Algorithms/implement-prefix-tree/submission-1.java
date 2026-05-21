class PrefixTree {
    PrefixTree[] children;
    boolean isEnd;
    PrefixTree root = null;

    public PrefixTree() {
        children = new PrefixTree[26];
        isEnd = false;     
    }

    public void insert(String word) {
        if(root == null){
            root = new PrefixTree();
        }

        PrefixTree curr = root;

        for(char c : word.toCharArray()){
            int index = c - 'a';
            if(curr.children[index] == null){
                curr.children[index] = new PrefixTree();
            }

            curr = curr.children[index];
        }
        curr.isEnd = true;
    }

    public boolean search(String word) {
        if(root == null) return false;

        PrefixTree curr = root;

        for(char c : word.toCharArray()){
            int index = c - 'a';
            if(curr.children[index] == null) return false;
            curr = curr.children[index];
        }

        return curr.isEnd;
    }

    public boolean startsWith(String prefix) {
        if(root == null) return false;

        PrefixTree curr = root;

        for(char c : prefix.toCharArray()){
            int index = c - 'a';
            if(curr.children[index] == null) return false;
            curr = curr.children[index];
        }

        return true;
    }
}
