# // Time Complexity : O(n)
# // Space Complexity :O(n)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        if (nums==[] or len(nums)==0):
            return [0,0]
        hashmap={}
        for i in range(len(nums)):
            complement=target-nums[i]
            if complement not in hashmap:
                hashmap[nums[i]]=i
            else:
                return [hashmap[complement],i]
                
                