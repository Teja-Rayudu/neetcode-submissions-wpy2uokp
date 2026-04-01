class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> anagrams = new ArrayList();

        int n = strs.length;
        boolean[] comp = new boolean[n];

        int i = 0;

        while(i < n){
            if(!comp[i]){
                comp[i] = true;
                List<String> group = new ArrayList();
                group.add(strs[i]);
                for(int j = 0; j < n; j++){
                    if( j != i && !comp[j] && validAnagram(strs[i], strs[j])){
                        comp[j] = true;
                        group.add(strs[j]);
                    }
                }
                anagrams.add(group);
            }
            i++;
        }
        return anagrams;
    }

    public boolean validAnagram(String s1, String s2){
        if(s1.length() != s2.length()) return false;
        int[] chars = new int[26];

        for(int i = 0; i < s1.length(); i++){
            chars[s1.charAt(i) - 'a']++;
        }

        for(int i = 0; i < s2.length(); i++){
            char c = s2.charAt(i);
            if(chars[c - 'a'] <= 0) return false;
            else chars[c - 'a']--;
        }

        return true;
    }
}
