class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int res = 0;
        int left = 0;
        int right = 0;

        Set seen = new HashSet();
        while(right < n){
            char c = s.charAt(right);
            while(seen.contains(c)){
                seen.remove(s.charAt(left));
                left++;
            }
            seen.add(c);
            res = Math.max(res, right - left + 1);
            right++;
        }

        return res;
    }
}
