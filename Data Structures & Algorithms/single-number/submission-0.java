class Solution {
    public int singleNumber(int[] nums) {
        if(nums.length == 1) return nums[0];
        int n = nums.length;
        int xor = nums[0];

        for(int i = 1; i < n; i++){
            xor ^= nums[i];
        }

        return xor;
    }
}
