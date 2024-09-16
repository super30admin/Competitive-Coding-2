#Two sum
#sc:O(N)
#tC:O(N)
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        if len(nums)<2:
            return False
        aux={}
        for i in range(len(nums)):
            if nums[i] in aux:
                return aux[nums[i]],i
            else:
                aux[target-nums[i]]=i
        