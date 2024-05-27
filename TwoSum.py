'''
TC: O(n)
SC: O(n)
'''
from typing import List

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        mydict = {}
        for i, v in enumerate(nums):
            if (target-v) in mydict:
                return [mydict[target-v], i]
            else:
                mydict[v] = i
s = Solution()
print(s.twoSum([2,7,11,15], 9))
print(s.twoSum([3,2,4], 6))
print(s.twoSum([3,3], 6))