# Time Complexity=O(n)
# Space COmplexity = O(n)

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        hm={}
        s=0
        for i in range(len(nums)):
            s=target-nums[i]
            if s in hm:
                return [i,hm[s]]
            hm[nums[i]]=i
            