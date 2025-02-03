# Two sum: https://leetcode.com/problems/two-sum/description/


class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        hm = {}
        length = len(nums)

        for i in range(length):
            comp = target - nums[i]
            if comp in hm:
                return [hm[comp],i]
            hm[nums[i]] = i

        return []