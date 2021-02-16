# One pass HashMap.
# Time Complexity - O(n)
# Space Complexity - O(n) to store n items in HashMap or dict


class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        if len(nums) == 0:
            return 0
        dict = {}
        for i in range(len(nums)):
            complement = target - nums[i]
            if complement not in dict:
                dict[nums[i]] = i
            else:
                return [dict[complement], i]