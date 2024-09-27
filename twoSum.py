# // Time Complexity : O(N)
 # // Space Complexity : O(N)
 # // Did this code successfully run on Leetcode : Yes
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        target_map = {}
        for idx,val in enumerate(nums):
            requiredValue = target-val
            if requiredValue in target_map:
                return [target_map[requiredValue],idx]
            else:
                target_map[val] = idx

    # // Time Complexity : O(Nlog(N))
    # // Space Complexity : O(N)
    # // Did this code successfully run on Leetcode : Yes
    def twoSumTwoPointer(self, nums: List[int], target: int) -> List[int]:
        nums = sorted(nums)
        result = set()
        l, r = 0, len(nums)-1
        while l < r:
            temp = nums[l] + nums[r]

            if temp == target:
                result.add((nums[l], nums[r]))
            if temp < target:
                l = l + 1
            else:
                r = r - 1
        return result

