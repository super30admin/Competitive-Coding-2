# Time Complexity : O(n)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
class Solution:
    def twoSum(self,nums,target):
        result = []
        if not nums:
            return result 
        d = {}
        for i in range(len(nums)):
            if target - nums[i] in d:
                result.append(d[target-nums[i]])
                result.append(i)
            else:
                d[nums[i]] = i 
        if len(result) != 2:
            return [-1,-1]
        return result 

if __name__ == "__main__":
    s = Solution()
    nums = [2, 7,11, 15]
    target = 9
    res = s.twoSum(nums,target)
    print(res)