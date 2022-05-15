'''
Time Complexity: O(N), where N is lenth of the list nums
Space Complexity: O(N), where N is length of list nums
Successfully executed in LeetCode: Yes
Challenges faced: No
'''


#CODE
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        temp = dict()
        for i in range(len(nums)):
            diff = target - nums[i]
            if diff in temp:
                return [temp[diff],i]
            temp[nums[i]] = i
        return []