"""
Space Complexity : O(N) as we have to create a hashmap for all the elements in the array
Time Complexity : O(N) as we have to traverse through the hashmap O(1) for lookup in hashmap
"""
class Solution:
    def twoSum(self, nums, target):
        #create an empty hashmap
        hashmap = {}
          
        for k,v in enumerate(nums): #run through the entire array
            b = target - nums[k] #check for the difference between target and every element in k
            if b in hashmap:#for every value in hashmap
                return [hashmap[b],k] #return the hashmap[key,val]
            hashmap[v] = k  #else populate the value in hashmap      
        return 
            

S = Solution()
nums = [2,11,15,7,0,9]
target = 9
print(S.twoSum(nums,target))