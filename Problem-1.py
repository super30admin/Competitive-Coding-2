# 1. Two Sum
# https://leetcode.com/problems/two-sum/

# Time complexiety: O(n)
# Space complexiety: O(n)

class Solution:
    def twoSum(self, nums, target):
        if not nums:
            return
        
        temp = dict()
        
        for idx, i in enumerate(nums):
            if target - i in temp.keys():
                return [idx,temp[target - i]]
            else:
                temp[i] = idx

obj = Solution()
print(obj.twoSum([2,7,11,15],9))
