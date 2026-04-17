class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];

        int sum = 0;

        for(int i = 0; i < n; i+=2){
            sum += nums[i];
        }

        int oddSum = 0;

        for(int i = 1; i < n; i+=2){
            oddSum += nums[i];
        }

        return Math.max(oddSum, sum);
    }
}
