'''Time Complexity: O(n)
Space Complexity: O(n)'''
class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        
        #Create a hashmap to store the values
        mapping=dict()
        
        for i in range(len(nums)):
            diff = target - nums[i]
            #Check if the difference is present in the hashmap
            if diff not in mapping:
                mapping[nums[i]]=i
            else:
                return [mapping[diff], i]
        
