class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0], nums[1]);

        return Math.max(find(0, n - 2, nums), find(1, n - 1, nums));
    }

    private int find(int start, int end, int[] nums){
       int prev1 = 0;
       int prev2 = 0;

        for(int i = start; i <= end; i++){
            int current = Math.max(prev1, nums[i] + prev2);
            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }
}
