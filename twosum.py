class Solution:
    def twoSum(self, nums, target):
        map = {}

        for i in range(len(nums)):
            cmp = target - nums[i]
            if cmp in map:
                return [map[cmp], i]
            map[nums[i]] = i

        return []

# TC - O(n)
# SC - O(n)