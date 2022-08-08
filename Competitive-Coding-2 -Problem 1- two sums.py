"""
S30 FAANMG Problem #29 {Easy }


1. Two Sum

Time Complexity : O(N)


Space Complexity : O(N)


Did this code successfully run on Leetcode : Yes
  
We are maintaing a hashmap to store the complement of the target and its index for each value

 For each value if the value is present in the hashmap, then its stored index and the current index is returned
 
 

@name: Rahul Govindkumar_RN27JUL2022
"""


class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        
        result=[]
        
        target_diff_dict={}
        
        for i,value in enumerate (nums):
            
            difference= target-value
            
            if(value in target_diff_dict.keys()):               
                return [target_diff_dict[value],i]
                
                
                
            target_diff_dict[difference]=i
                
                
      
       

            
        