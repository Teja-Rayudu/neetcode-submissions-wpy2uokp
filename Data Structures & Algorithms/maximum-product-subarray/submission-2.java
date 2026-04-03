class Solution {
    public int maxProduct(int[] nums) {
        //kadanes algo
        if(nums.length == 1) return nums[0];
        int max = nums[0], min = nums[0], global = nums[0];
        for(int i = 1; i < nums.length; i++){
            int temp = max*nums[i];
            max = Math.max(nums[i], Math.max(nums[i] * max, nums[i] * min));
            min = Math.min(nums[i], Math.min(temp, nums[i] * min));
            global = Math.max(global,max);
        }

        return global;
    }
}
