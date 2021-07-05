#two sum
#Time Complexity: O(N).
#Auxiliary Space: O(N)
#Did this code successfully run on leetcode :Yes

class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        hashmap = {}
        for index,num in enumerate(nums):
            comp = target - num
            if comp in hashmap:
                return [hashmap[comp],index]
            else:
                hashmap[num] = index