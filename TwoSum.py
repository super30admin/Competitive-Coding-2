# TC = O(n)
# SC = O(n)
# Using hashmap
class Solution:
    def twoSum(self, nums, target):
        d={}
        # We store each num with its index on the array
        for i in range(len(nums)):
            d[nums[i]] = i
        # we check if compliment of current num already exists in the hashmap- if it does we return current index and one stored already
        for i in range(len(nums)):
            check=target-nums[i]
            if check in d and d[check] != i:
                return [i, d[check]]
        