class Solution {

    public String encode(List<String> strs) {
        StringBuilder res = new StringBuilder();
        for(String s : strs){
            res.append(s.length()).append('#').append(s);
        }

        return res.toString();
    }

    public List<String> decode(String str) {
        int n = str.length();

        int i = 0;
        List<String> strs = new ArrayList<>();

        while(i < n){
            int j = i;
            while(str.charAt(j) != '#'){
                j++;
            }
            int len = Integer.parseInt(str.substring(i,j));
            i = j + 1;
            j = i + len;
            strs.add(str.substring(i, j));
            i = j;
        }

        return strs;
    }
}
