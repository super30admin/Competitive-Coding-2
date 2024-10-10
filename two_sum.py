class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        hash = {}

        for i, num in enumerate(nums):
            diff = target - num
            if diff in hash:
                return [hash[diff], i]
            else:
                hash[num] = i


# time complexity is O(n) where n is the number of elements in nums array
# space complexity is O(n) where n is the number of elements in nums array
