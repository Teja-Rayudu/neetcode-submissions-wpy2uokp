class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList();
        recur(0, s, new ArrayList(), res);
        return res;
    }

    private void recur(int index, String s, List<String> path, List<List<String>> res){
        if(index == s.length()){
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i = index; i < s.length(); i++){
            if(isPalindrome(index, i, s)){
                path.add(s.substring(index, i + 1));
                recur(i + 1, s, path, res);
                path.removeLast();
            }
        }
    }

    private boolean isPalindrome(int start, int end, String s){
        while(start <= end){
            if(s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }

        return true;
    }
}
