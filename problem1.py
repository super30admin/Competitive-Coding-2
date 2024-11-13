#2sum t:O(n) and s:O(1)
class Solution:
    def twosum(self,nums:list[int], target:int):
        seen = {}                           # we create a hashmap of seen items
        
        for i in range(len(nums)):  
            diff = target - nums[i]         # find diffrence  

            if diff in seen:                # if found -> output 
                return(i, seen[diff])
            else:
                seen[nums[i]] = i           # store key = nums[i] and value = index in the Hashmap 



    

arr = [2,4,5,7,9,11,15]

print(Solution().twosum(arr,7))
