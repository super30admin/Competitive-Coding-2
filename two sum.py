#// Time Complexity : O(n) 
# // Space Complexity : O(n) 
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : no because i saw the class video and then did the problem.

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        hashMap={}
        for i in range(len(nums)):
            complement=target-nums[i]
            if complement in hashMap:
                return [i,hashMap[complement]]
            hashMap[nums[i]]=i

# Approach:
# 1. Create an empty dictionary called hashMap to store the numbers we have seen so far
# 2. Iterate over the list of numbers with their indices using a for loop
# 3. For each number, calculate its complement by subtracting it from the target
# 4. Check if the complement is in the hashMap. If it is, return the current
# index and the index of the complement in the hashMap
# 5. If the complement is not in the hashMap, add the current number and its index
# to the hashMap