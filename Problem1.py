# https://leetcode.com/problems/two-sum/description/

# Bruteforce solution
# TC: O(n^2)

class Solution:
    def twoSum(self, nums, target):
        res = []
        for i in range(0, len(nums)):
            for j in range(i+1, len(nums)):
                if nums[i] + nums[j] == target:
                    res += [i, j]
                    
        return res
    
s = Solution()
print(s.twoSum([2,7,11,15], 17))

# Hashmap
# TC: O(2n) => O(n)

class Solution:
    def twoSum(self, nums, target):
        hm = {}
        n = len(nums)
        res = []
        
        for i in range(n):
            if nums[i] not in hm:
                hm[nums[i]] = i
                
        for i in range(n):
            comp = target - nums[i]
            if comp in hm:
                res += [i, hm[comp]]
                del hm[nums[i]]
                del hm[comp]
                
        return res
    
s = Solution()
print(s.twoSum([2,7,11,15], 9))

# Hashmap with one pass
# TC: O(n)

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        hm = {}
        
        for i, num in enumerate(nums):
            comp = target - num
            if comp in hm:
                return [hm[comp], i]
            hm[num] = i