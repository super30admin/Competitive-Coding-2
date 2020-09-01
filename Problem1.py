# Leetcode problem link : https://leetcode.com/problems/two-sum/
# Time Complexity : O(n)
#  Space Complexity : O(n)
#  Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
'''
        Basic approach : 1. O(n2) => Start from each index and calculate the sum for every other element and compare with target. If it is equal to target return response else continue from next index

        Optimized approach: O( n ) => Maintain a hashmap of the elements we come across while traversing, if at any point the complement of the number is existing in the hasmpa then return the current index and the index for the complement stored in hashmap
'''
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
    	# edge case when array is empty
        if not nums or len(nums) == 0:
            return [-1,-1]
         # create a dictionary with key as element and value as its index
        num_map = {}
        for i,num in enumerate(nums):
        	# Calculate the complement of the current number
            comp = target - num
            # If it exists in the hashmap return the index from dictionary and current index
            if comp in num_map:
                return [num_map[comp],i]
             # else add the current index and number to the dictionary
            num_map[num] = 
        # if we have reached this point then no such combination exists
        return [-1,-1]