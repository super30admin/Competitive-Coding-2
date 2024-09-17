class Solution:
    # leetcode URL : https://leetcode.com/problems/two-sum/
    # Problem : 1. Two Sum
    # Time Complexity : O(n)
    # Space Complexity : O (n)
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        difference_set = dict()
        for i in range(0,len(nums)):
            if nums[i] in difference_set.keys():
                return (i,difference_set[nums[i]])
            else:
                difference_set[target-nums[i]] = i