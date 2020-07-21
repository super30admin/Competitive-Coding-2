#Time Complexity: O(n) where n is the length of input array
#Space complexity: O(n) where n is the legnth of input array
# Runs on leetcode: yes
#Approach - We keep each element and it's corresponding index in a dictionary while iterating through the array. But each time 
# we will check if the (target - num) is in the dictionary. If it is, we return both num and (target-num) index
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        if not nums:
            return [-1,-1]
        mapping = {}
        for i in range(len(nums)):
            if (target - nums[i]) in mapping:
                return [mapping[target - nums[i]], i]
            mapping[nums[i]] = i 
        return [-1,-1]