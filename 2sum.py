# TC: O(n)
# SC: O(n)

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        dict1 = {}
        for i in range(len(nums)):
            rem = target - nums[i]
            if rem in dict1:
                return (dict1[rem], i)
            dict1[nums[i]] = i