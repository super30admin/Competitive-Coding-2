#Time complexity: O(n) as we are iterating through the nums list once.
#Space: O(n) for using the hashmap

# Logic is simple, just store the difference of target and num in hashmap, if we find the same number again in the list then thats our sum.

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        hashmap = {}
        for i, num in enumerate(nums):
            if num in hashmap:
                return [i, hashmap[num]]
            hashmap[target-num] = i