class Solution:
    def findPairs(self, nums: List[int], k: int) -> int:
        if nums==None or len(nums)==0:
            return 0
        i=0
        j=1
        nums.sort()
        count=0
        
        while (j<len(nums)):  
            if i==j:
                j+=1
                
            elif nums[j]-nums[i]==k and nums[j]!=nums[i]:
                i+=1
                j+=1
                count+=1
            elif nums[j]-nums[i]==k and nums[j]==nums[i]:
                i+=1
                j+=1
                count=1
            elif nums[j]-nums[i]>k:
                i+=1
            elif nums[j]-nums[i]<k:
                j+=1
            
        return count
