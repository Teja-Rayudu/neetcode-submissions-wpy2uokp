class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        max_profit = 0
        min_price = prices[0]
        for i in range(1,len(prices)):
            if prices[i] < min_price: #greedily choosing min prices
                min_price = prices[i]
            elif prices[i] - min_price > max_profit: # greedily choosing max profit at that time
                max_profit = prices[i] - min_price
        
        return max_profit
        