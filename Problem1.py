#Time Complexity: O(N)
#Space Complexity: O(N)
class Solution:
    def twoSum(self, nums: List[int], k: int) -> List[int]:
        dic = {}
        for i in range(len(nums)):
            if k - nums[i] in dic:
                return [dic[k-nums[i]],i]
            else:
                dic[nums[i]] = i
        
                