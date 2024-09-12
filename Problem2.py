from typing import List
# Time Complexity : O(n), Where n is number of elements in nums
# Space Complexity : O(n), Where n is number of elements in nums
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Nothing specific
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        #This dic is used to keep track of index of occurance of element
        dic={}
        for i in range(len(nums)):
            comp=target-nums[i]
            if(comp in dic):
                return [dic[comp][0], i]
            else:
                dic[nums[i]]=[i]
        