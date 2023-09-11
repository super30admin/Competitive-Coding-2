#time complexity : O(n)
#space complexity: O(n)

class Solution:
    def twoSum(self, nums, target):
        dictionary = {}
        for i in range(len(nums)):
            if target-nums[i] in dictionary:
                return [dictionary[target-nums[i]], i]
            dictionary[nums[i]] = i
