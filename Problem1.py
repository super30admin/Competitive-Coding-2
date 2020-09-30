# Time Complexity: O(N)
# Space Complexity: O(N)
# Leetcode all test cases passed: Yes
# Any Difficulties: No

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        dic = {}
        for i in range(0, len(nums)):
            ans = target - nums[i]
            if ans not in dic:
                dic[nums[i]] = i
            else:
                return [i, dic[ans]]
