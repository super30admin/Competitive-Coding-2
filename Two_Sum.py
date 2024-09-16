#Time Complexity : O(N) for traversing the inputs
#Space Complexity : O(N) for storing in Hashmap which can be equal to number of inputs
class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        d ={}
        start = 0
        end = 0
        for i in range(len(nums)):
            if target - nums[i] in d:
                start = d[target-nums[i]]
                end = i
            else:
                d[nums[i]] = i  
        return(start,end)

