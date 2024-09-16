"""
Approach:
store all occurrences in a hashmap
take compliment at each index and check if it has occured already, if yes, we have found the pair. if not, keep looking

"""
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        if not nums:
            return nums
        hash_map = {}

        for i in range(len(nums)):
            compliment = target - nums[i]
            if compliment in hash_map:
                return ([i, hash_map[compliment]])
            else:
                hash_map[nums[i]] = i
        return -1

"""
TC: O(n)
SC: O(n)
"""
