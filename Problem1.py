# 2-sum https://leetcode.com/problems/two-sum/
# Time complexity: O(nlogn)
# Space complexity: O(1)

class Solution:
    def findSum(self, nums, target):
        for i in range(0, len(nums)):
            if i < len(nums) -1 and nums[i] > nums[i+1]:
                temp = nums[i]
                nums[i] = nums[i+1]
                nums[i+1] = nums[i]
        j = len(nums) - 1
        for i in range(0, len(nums)):
            while i <= j:
                if nums[i] + nums[j] == target:
                    return [i,j]
                j = j - 1
        return [-1, -1]

# Driver code
s = Solution()
print(s.findSum([2,3,7,8,9], 9))