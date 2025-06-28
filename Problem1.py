#Brute force
#Time Complexity: O(n^2)
#Space Complexity: O(1)
# class Solution:
#     def twoSum(self, nums, target):
#         n = len(nums)
#         for i in range(n):
#             for j in range(i + 1, n):
#                 if nums[i] + nums[j] == target:
#                     return [i, j]
#         return [-1, -1]

#HashMap
#Time Complexity: O(n), iterate through the nums array once — each of the n elements is visited exactly once. Search is O(1) due to hashmap
#Space Complexity: O(n), In the worst case (no solution found until the end), storing each of the n elements in the hash map
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        n = len(nums)
        hashmap = {}
        for i in range(n):
            r=target-nums[i]
            if r in hashmap:
                return [i, hashmap[r]]
            hashmap[nums[i]]=i
        