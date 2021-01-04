class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        x = {}
        for i in range(0,len(nums)):
            x[target-nums[i]] = i
        
        for i in range(0,len(nums)):
            if(nums[i] in x.keys()):
                j = x[nums[i]]
                if(i!=j):
                    return([i,j])
        
        return [-1,-1]
