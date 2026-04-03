class Solution {
    public int maxSubArray(int[] nums) {
        int globalSum = 0;
        for(int num : nums){
            globalSum += num;
        }
        int currSum = 0;
        for(int i = 1; i < nums.length; i++){
            currSum = Math.max(nums[i], currSum + nums[i]);
            globalSum = Math.max(currSum, globalSum);
        }
        return globalSum;
    }
}
