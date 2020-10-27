# Simple brute force solution to 2 Sum problem is using 2 for loops to subtract and find the target 
# Time Complexity: O(n^2)
# Space complexity: O(n)
#Problem: How  do I optimize it to make O(n)?
def twoSum(self, nums, target):
    for i in range(len(nums)):
        for j in range(i+1,len(nums)):
            if (nums[j] == target - nums[i]):
                return (i,j)
nums = [2,7,11,15]
target = 9
twoSum(nums,target)
