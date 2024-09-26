"""
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Output: Because nums[0] + nums[1] == 9, we return [0, 1].

Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
"""
"""
Solution:
    create a map, for each number check its compliment to the map,
    if it doesn't exists add number as key and its index as value 
    if the compliment already in the map return current index and value assosciated with 
    number in the map
"""


def twoSum(nums, target):
    if(nums == None or len(nums)==0):
        return (-1,-1)
    complimentDict = {}
    for i in range(len(nums)):
        compliment = target - nums[i]
        if(compliment in complimentDict):
            return (i, complimentDict[compliment])
        else:
            complimentDict[nums[i]] = i
    return (-1,-1)

print(twoSum([2, 7, 11, 15], 9))
print(twoSum([2, 7, 11, 15], 20))