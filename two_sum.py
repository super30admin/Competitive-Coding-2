class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        
        #TC = O(N)
        #SC = O(N)
        
        hm = {}
        res = []
        
        for i in range(len(nums)):
            if target - nums[i] in hm.keys():
                res.append(hm[target-nums[i]])
                res.append(i)
                return res
            else:
                hm[nums[i]] = i