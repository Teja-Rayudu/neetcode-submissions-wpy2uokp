class Solution:
    def isHappy(self, n: int) -> bool:
        def sqr_sum(n:int) -> int:
            sum = 0
            while n != 0:
                x = n % 10
                sum += x*x
                
                n //= 10

            return sum
        sum_num = 0;
        dups = set()

        while sum_num != 1:
            if sum_num in dups:
                return False
            
            sum_num = sqr_sum(n)
            dups.add(sum_num)
            n = sum_num;
        
        return True




        