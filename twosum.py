class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:

        index = {}

        for i in range(len(nums)):
            c = target - nums[i]
            if c in index:
                return (index[c],i)
            index[nums[i]] = i


