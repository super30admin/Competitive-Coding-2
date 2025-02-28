class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        #Brute Force : T.C : O(N^2)
        n = len(nums)
        for i in range(0,n):
            for j in range(i+1,n):
                if(nums[i]+nums[j]==target):
                    return [i,j]

        #Optimized : T.C : O(N), S.C : O(N)
        n = len(nums)
        hashset={}
        for i in range(0,n):
            complement=target-nums[i]
            if(complement in hashset):
                return[i,hashset[complement]]
            else:
                hashset[nums[i]]=i
        return []