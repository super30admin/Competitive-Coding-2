# time complexity : 0(n)
#space complexity : 0(n)
class Solution(object):
    def twoSum(self, nums, target):
        
        n = len(nums)
        
        if n == 0:
            return -1,-1
        
        mymap = {}
        
        for index in range(n):
            if (target - nums[index]) in mymap:
                return mymap[target-nums[index]] , index
            else:
                mymap[nums[index]] = index
                
        return -1,-1
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        