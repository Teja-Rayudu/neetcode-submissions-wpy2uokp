class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty()) return new ArrayList<>();

        List<String> res = new ArrayList();
        res.add("");

        String[] digitToChar = {"","","abc","def", "ghi","jkl", "mno",  "pqrs", "tuv", "wxyz"};

        for(char digit : digits.toCharArray()){
            List<String> tmp = new ArrayList<>();

            for(String currStr : res){
                for(char c : digitToChar[digit - '0'].toCharArray()){
                    tmp.add(currStr + c);
                }
            }
            res = tmp;
        }
        return res;
    }
}
