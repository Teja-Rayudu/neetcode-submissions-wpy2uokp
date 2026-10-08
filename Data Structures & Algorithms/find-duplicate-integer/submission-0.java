class Solution {
    public int findDuplicate(int[] nums) {
        Map<Integer, Boolean> map = new HashMap<>();
        for(int i : nums){
            if(map.getOrDefault(i, false)) return i;
            map.put(i, true);
        }
        return 0;
    }
}
