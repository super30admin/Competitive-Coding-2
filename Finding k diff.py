class Solution:
    def findPairs(self, nums: List[int], k: int) -> int:
        if nums==None or len(nums)==0:
            return 0
        i=0
        j=1
        nums.sort()
        count=0
        
        while (j<len(nums)):  
            if nums[j]-nums[i]<k or i==j:
                j+=1
            
            elif nums[j]-nums[i]>k:
                i+=1
            
            elif nums[j]-nums[i]==k:
                i+=1
                j+=1
                count+=1
                while j<len(nums) and nums[j]==nums[j-1]:
                    j+=1
            
        return count
