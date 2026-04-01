class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        max_profit = 0
        for i in range(len(prices)):
            stock = prices[i];
            for j in range(i + 1, len(prices)):
                if stock > prices[j]:
                    continue
                profit = prices[j] - stock
                max_profit = max(max_profit, profit)
        
        return max_profit
        