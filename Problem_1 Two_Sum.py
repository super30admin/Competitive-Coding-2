# // Time Complexity : O(n)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No
#
#
# // Your code here along with comments explaining your approach

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        hashmap = {}
        answer = []
        for i in range(len(nums)):
            num2 = target - nums[i]
            if (num2 in hashmap.keys()):
                num2_index = nums.index(num2)
                if (i != num2_index):
                    return sorted([i, num2_index])
            hashmap.update({nums[i]: i})
