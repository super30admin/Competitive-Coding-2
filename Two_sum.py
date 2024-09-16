# Using 2-d array, weights as rows and possible capacities(< given capacity) as columns.
# Time Complexity : O(n) + O(n) = O(n)
# Space Complexity : O(n).
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#
#
# Your code here along with comments explaining your approach
# Using 2-d array, weights as rows and possible capacities(< given capacity) as columns.


class Solution:
    def twoSum(self, nums: list[int], target: int) -> list[int]:
        dictu = {}
        for i in range(len(nums)):
            if nums[i] not in dictu:
                dictu[nums[i]] = [i]
            else:
                dictu[nums[i]].append(i)
        for i in dictu:
            if len(dictu[i]) > 1 and i * 2 == target:
                return [dictu[i][0], dictu[i][-1]]
            if target - i in dictu and target - i != i:
                return [dictu[i][0], dictu[target - i][0]]


check = Solution()
print(check.twoSum([2, 7, 11, 15], 9))


# brute force approach
# class Solution:
#     def twoSum(self, nums: List[int], target: int) -> List[int]:
#         start = 0
#         end = len(nums) - 1
#         while start <= end:
#             if nums[start] + nums[end] == target:
#                 return [start, end]
#             end -= 1
#             if start == end:
#                 end = len(nums) - 1
#                 start += 1


# check = Solution()
# print(check.twoSum([2, 7, 11, 15], 9))
