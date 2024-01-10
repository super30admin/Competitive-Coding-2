#time complexity: O(n)
#space complexity: O(n)
#submit on leetcode:yes 



from typing import List

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        n = len(nums)
        result = []

        index_map = {}
        i = 0
        while i < n:
            required_num = target - nums[i]

            if required_num in index_map:
                result.append([index_map[required_num], i])
            else:
                index_map[nums[i]] = i
            
            i += 1  

        return result[0]


sol = Solution()
nums = [2,7,11,15]
tar = 13
res = sol.twoSum(nums,tar)
print("Two sum:",res)