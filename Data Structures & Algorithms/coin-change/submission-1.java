class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        int max = amount + 1;
        Arrays.fill(dp, max);
        dp[0] = 0;

        for(int sum  = 1; sum <= amount; sum++){
            for(int coin : coins){
                
                if(coin <= sum){
                    dp[sum] = Math.min(dp[sum], dp[sum - coin] + 1);
                }
            }
        }

        int result = dp[amount];
        if(result == max) return -1;

        return result;
    }
}
