"""
Approach: use a hashmap to track (nums[i], i) and as soon as target - nums[i] is found return both the indexes
t.c.=> O(n)
s.c.=> O(n)
"""
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        indexMap = collections.defaultdict(int) 
        n = len(nums)

        for i in range(n):
            a = target - nums[i]
            if a in indexMap:
                return [indexMap[a], i]

            indexMap[nums[i]] = i
        return []