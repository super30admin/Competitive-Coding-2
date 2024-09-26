'''
====== Submission Details =======
Student Name: Pavan Kumar K. N.
S30 SlackID : RN32MAY2021
=================================
'''
# Given an array of integers nums and an integer target, return indices of 
# the two numbers such that they add up to target.

# You may assume that each input would have exactly one solution, 
# and you may not use the same element twice.

# You can return the answer in any order.


# Example 1:
# Input: nums = [2,7,11,15], target = 9
# Output: [0,1]
# Output: Because nums[0] + nums[1] == 9, we return [0, 1].

# Example 2:
# Input: nums = [3,2,4], target = 6
# Output: [1,2]

# Example 3:
# Input: nums = [3,3], target = 6
# Output: [0,1]


#-----------------
# Time Complexity: 
#-----------------
# O(N): Need to iterate over input array once. 
#------------------
# Space Complexity: 
#------------------
# O(N) - Need hashmap to store maximum <value, index> key value pairs

#-----------------------
# Leet Code Performance: 
#-----------------------
# Ran Successfully?: Yes

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        sum_map = {}
        if len(nums) == 0:
            return [-1, -1]
        for i in range(len(nums)):
            if target - nums[i] in sum_map:
                return [sum_map[target-nums[i]], i]
            else:
                sum_map[nums[i]] = i
        
        return [-1, -1]
        