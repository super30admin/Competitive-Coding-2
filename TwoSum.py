#Time Complexity: O(n)
# Space Complexity: O(1)
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:

        len1 = len(nums)
        for i in range(len1):
            for j in range(len1):

                if nums[i] + nums[j] == target:
                    if i == j:
                        continue
                    else:
                        return i, j
