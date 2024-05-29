# Time Complexity
# O(n)
# Space Complexity
# O(n)

# Approach :

# traverse through the array and use a hashmap
# find the complement value, that is target - nums[i]
# if complement does not exist in the hashmap, store the current element as key and its index as value
# if complement exists in hashmap, return the complement as well as the current element 's index


class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:

        if not nums:
            return []

        hashMap = {}
        flag = 0

        for i in range(len(nums)):
            complement = target-nums[i]

            if complement in hashMap:
                return [hashMap[complement], i]

            else:
                hashMap[nums[i]] = i

        if flag == 0:
            return [-1, -1]
