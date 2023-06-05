#Time Complexity is: O(n) where n is the length of the array
#Space Complexity is: O(n) where n is the length of the array
#Code ran successfully on leetcode
#Faced no problems while coding this problem

class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        #Creating a hashmap to store values in nums array as key and index as value 
        self.dic={}
        for i in range(0,len(nums)):
            #We will check target-nums[i] and if the difference in present as key in hashmap
            #we will return both the indexes 
            if(target-nums[i] in self.dic):
                return [i,self.dic[target-nums[i]]]
            else:
            #If the difference is not present as key, then we will store nums[i] as key and i as value
                self.dic[nums[i]]=i
        