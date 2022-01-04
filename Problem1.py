
"""

Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

"""

# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on leetcode : Yes
# Any problem you faced while coding this : No


from typing import List

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        
        map1 = {}

        for i in range(len(nums)):

            if target - nums[i] in map1:
                return [map1[target - nums[i]], i]

            else:
                map1[nums[i]] = i


input_list = [2,8,12,15]
ob1 = Solution()
print(ob1.twoSum(input_list, 20))