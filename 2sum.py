class Solution:
    def twoSum(self, nums: list[int], target: int) -> list[int]:
        if len(nums) < 2:
            return [-1.0 - 1]
        cal_dict = {}
        for i in range(len(nums)):
            temp = target - nums[i]
            if cal_dict.get(nums[i]) != None:
                return [i, cal_dict[nums[i]]]
            else:
                cal_dict[temp] = i
        return [-1, -1]
