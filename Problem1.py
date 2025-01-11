# Time Complexity  = O(n)
# Space Complexity = O(n)
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        # key(value) -> value(index of value in nums)
        hashMap = {}
        for i,n in enumerate(nums):
            diff = target - n
            if diff in hashMap:
                return (hashMap[diff],i)
            hashMap[n] = i