class Solution:
    def twoSum(self, nums: list[int], target: int) -> list[int]:
        left = 0
        right = len(nums) - 1
        result = []
        nums.sort()
        while (left < right):
            if (nums[left] + nums[right] == target):
                result.append(left)
                result.append(right)
            elif (nums[left] + nums[right] > target):
                right -= 1
            else:
                left += 1

nums = [2,7,11,15]
object = Solution()
print(object.twoSum(nums, 9))