# Time Complexity: O(n)
# Space Complexity: O(n)
# Did it run on Leetcode: Yes
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        hash_set = {}
        for i in range(len(nums)):
            ans = target - nums[i]
            if ans in hash_set:
                return [i,hash_set[ans]]
            else:
                hash_set[nums[i]] = i
        return [-1,-1]