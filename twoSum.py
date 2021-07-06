class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        if not nums:
            return [-1, -1]
        
        h = {}
        
        for i in range(len(nums)):
            if (target - nums[i]) in h.keys():
                return (h[target - nums[i]], i)
            else:
                h[nums[i]] = i
        
        
# TC O(N) SC O(N)
# creating a hashmap, storing if the compliment of that value does not exists
# otherwise returning index