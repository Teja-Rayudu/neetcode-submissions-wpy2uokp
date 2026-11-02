class Solution:
    def isHappy(self, n: int) -> bool:
        def sqr_sum(n:int) -> int:
            sum = 0
            while n != 0:
                x = n % 10
                sum += x*x
                
                n //= 10

            return sum
        dups = set()

        while n != 1 and n not in dups:
            dups.add(n)
            n = sqr_sum(n)
        
        return n == 1




        