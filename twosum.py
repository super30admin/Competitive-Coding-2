# Two sum implementation
# LeetCode problem: https://leetcode.com/problems/two-sum/
def two_sum(nums, target):
    values = {} # Dictionary to store values and their indices. If we want to return the numbers, we can use a set instead.
    for i,n in enumerate(nums):
        comp = target-n
        if comp in values:
            return [values[comp],i] # Return indices of the two numbers that add up to target
        values[n] = i 
    return [] # No solution found
