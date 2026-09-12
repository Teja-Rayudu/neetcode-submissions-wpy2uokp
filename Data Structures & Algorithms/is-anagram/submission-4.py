class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False
        
        s_chars = {}
        
        for i in s:
            if i not in s_chars:
                s_chars[i] = 0
            s_chars[i] += 1
        
        for i in t:
            if i not in s_chars:
                return False
            s_chars[i] -= 1
        
        for val in s_chars.values():
            if val != 0:
                return False
        
        return True