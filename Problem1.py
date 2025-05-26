"""
I first check the difference between the number and the target. If it's not in the HashMap, I add the number to the HashMap. If it is present, I return the indices of the two elements.
Time Complexity: O(n)
Space Complexity: O(n)
"""
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        hashMap = {}
        for i, num in enumerate(nums):
            difference = target - num
            if difference in hashMap:
                return [hashMap[difference], i]
            hashMap[num] = i
        return []