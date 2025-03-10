class Solution(object):
    def twoSum(self, nums, target):
        map ={}
        for i, n in enumerate(nums):
            diff = target-n
            if diff in map:
                return [map[diff],i]
            map[n] = i
        return 
