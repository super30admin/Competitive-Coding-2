class Solution:
# // Time Complexity :O(n) where n is the length of array
# // Space Complexity :O(n)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


# // Your code here along with comments explaining your approach
    
    
    
    
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        dict={}
        # dict[0]=-1
        
        res=[]
        
        # print(nums)
        # print(target)
        for i in range(len(nums)):
            
            if target-nums[i] not in dict.keys():
                dict[nums[i]]=i
            else:
                
                res.append(dict[target-nums[i]])
                res.append(i)
            # print(dict)
        
                    
        return res
                
            
        