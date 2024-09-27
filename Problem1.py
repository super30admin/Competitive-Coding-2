# Time Complexity=O(n)
# Space COmplexity = O(n)
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        arr=[]
        val=0
        for i in range(len(nums)):
            val=target-nums[i]
            if val in arr:
                return [i,arr[val]]
            arr[nums[i]]=i