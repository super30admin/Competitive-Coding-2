  ---------------------- Two Sum ------------------------------------------------   
# Time Complexity : O(N) N is the length of the Array.
# Space Complexity : O(N)  dict
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# 
# To calculate the indexes of target sum, we can iterate through the array and check if nums[i] is already present in the dict.
#If yes, the we have already a number which is the difference of target-nums[i], then we can return index of that previous number and present target.
#If not present in the dict, then we can place the target-nums[i] with its index in the dict




class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        if not nums:
            return [-1,-1]
        
        d = {}
        for i in range(len(nums)):
            if nums[i] in d:
                return [d[nums[i]], i]
            else:
                d[target-nums[i]] = i
        return [-1,-1]