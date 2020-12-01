# 2-sum.
# Time Complexity - O(N)

# Space Complexity - O(N)

# Approach
# I use a hashmap where I first check if the complement of the element with the target is present in the hashmap
# If not I add the (element, index) pair to the map and if present return the value and the index of the element.

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        if (nums == None or len(nums) == 0):
            return [-1, -1]

        hashMap = {}
        for i in range(len(nums)):
            complement = target - nums[i]
            if complement in hashMap:
                return [hashMap[complement], i]
            else:
                hashMap[nums[i]] = i



