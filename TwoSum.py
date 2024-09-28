class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        n=len(nums)
        hm={}
        for i in range(n):
            s=target-nums[i]
            if s in hm:
                return [i,hm[s]]
            hm[nums[i]]=i
            

