# Space Complexity: O(1)
# Time Complexity: O(max(len(order), len(s)))
class Solution(object):
    def customSortString(self, order, s):
        """
        :type order: str
        :type s: str
        :rtype: str
        """
        cnt = {}
        for c in s:
            if c not in cnt:
                cnt[c] = 1
            else:
                cnt[c] += 1
        ans = ''
        for c in order:
            if c in cnt and cnt[c] >0:
                ans += c*cnt[c]
                cnt[c] = 0
        for key, value in cnt.items():
            if value > 0:
                ans += key*value
        return ans
