class Solution {
    public int maxProduct(int[] nums) {
        //kadanes algo
        int max = nums[0], min = nums[0], global = Integer.MIN_VALUE;
        for(int i = 1; i < nums.length; i++){
            max = Math.max(nums[i], Math.max(nums[i] * max, nums[i] * min));
            min = Math.min(nums[i], Math.min(nums[i] * max, nums[i] * min));
            global = Math.max(global,max);
        }

        return global;
    }
}
