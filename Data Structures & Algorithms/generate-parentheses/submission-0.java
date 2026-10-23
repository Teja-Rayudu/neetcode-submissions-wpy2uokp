class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> paranths = new ArrayList();
        generate(n, 0, "", paranths);

        return paranths;
    }

    private void generate(int open, int close, String path, List<String> paranths){
        if(open == 0 && close == 0){
            paranths.add(path);
            return;
        }

        if(open > 0) generate(open - 1, close + 1, path + "(", paranths);
        if(close > 0) generate(open, close - 1, path + ")", paranths);
    }
}
