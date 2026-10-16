class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null) return new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();

        for(String s: strs){
            char[] str = s.toCharArray();
            Arrays.sort(str);

            String sorted = new String(str);

            map.putIfAbsent(sorted, new ArrayList());
            map.get(sorted).add(s);
        }

        List<List<String>> res = new ArrayList();

        for(List<String> val : map.values()) res.add(val);

        return res;
    }
}
