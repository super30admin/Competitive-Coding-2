# Time Complexity: O(n)
# Space Complexity: O(1)
class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        dic = {}
        res = 0
        lst = 0
        for i in range(len(s)):
            if s[i] in dic:
                lst = max(lst, dic[s[i]]+1)
            res = max(res, i-lst+1)
            dic[s[i]] = i
        return res
                
                
        
