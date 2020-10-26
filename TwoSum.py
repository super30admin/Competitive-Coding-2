#Time Complexity : O(n) where n is the number of elements in the given array
#Space Complexity : o(n) where n is the number of elements in the given array

#Did this code successfully run on Leetcode : Yes
#Three line explanation of solution in plain english: Maintain a dictionary with element and it's index, while iterating through the array. On reaching every new index check whether target - nums[i] is present in the dictionary, if it then return the two indices of the elements which add upto the target.

#Your code here along with comments explaining your approach

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        d = {}

        for i in range(len(nums)):

            diff = target-nums[i]
            #check if difference exists in dictionary
            if diff in d:
                return [d[diff], i]
            else:
                d[nums[i]] = i

        return[-1, -1]
