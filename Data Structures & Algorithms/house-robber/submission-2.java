class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        return dfs(nums, n - 1, memo);
    }

    private int dfs(int[] nums, int i, int[] memo){
        if(i < 0) return 0;

        if(memo[i] != -1){
            return memo[i];
        }

        memo[i] = Math.max(dfs(nums, i - 1, memo), nums[i] + dfs(nums, i - 2, memo));

        return memo[i];
    }
}
