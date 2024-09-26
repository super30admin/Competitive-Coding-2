class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        mapp = {}
        for i in range(len(nums)):
            if target-nums[i] in mapp:
                return [i, mapp[target-nums[i]]]
            mapp[nums[i]] = i