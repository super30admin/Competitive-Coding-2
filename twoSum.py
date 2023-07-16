# Time: O(n)
# space: O(n)
# did the code run? yes
# Approach:
# using a hashmap store all numbers encountered and their indices.
# when a new number is visited, check if its compliment is already present in the hashmap. else add it to the hashmap and move next.

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        seen = {}
        for i in range(len(nums)):
            compliment = target - nums[i]
            if compliment in seen:
                return [seen[compliment], i]
            seen[nums[i]] = i