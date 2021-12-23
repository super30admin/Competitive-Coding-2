# Time Complexity - O(n)
# Space Complexity - O(n)
# Approach - Use a dictionary to store the indices as values and search for (target - arr[ele])
class Solution:
    def twoSum(self, nums, target: int):
        d = dict()
        for i in range(len(nums)):
            if (target - nums[i]) in d:
                return [i, d[target-nums[i]]]
            else:
                d[nums[i]] = i