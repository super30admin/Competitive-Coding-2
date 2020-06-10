// Time Complexity :o(n)
// Space Complexity :(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
//Looping through all the elements and calculatet he complement to get the target. if the target is already present in the hashmap return both the indice if not add the number and index to the hash map. 


class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        
        dict =  {}
        for i in range(len(nums)):
            
            complement = target - nums[i]
            
            if(complement in dict.keys()):
                return [dict[complement],i]
            else:
                dict[nums[i]] = i
            
        
