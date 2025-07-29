# TimeComplexity:O(n)
# SpaceComplexity:O(n)
# Approach:use 2 loops for BF, use hasmap to find target-nums[i]



class Solution:
    def twoSum(self, nums: List[int], t: int) -> List[int]:
        hmap={}
        n=len(nums)
        for i  in range(n):
            if nums[i] in hmap:
                return [i,hmap[nums[i]]]
            else:
                hmap[t-nums[i]]=i

        
