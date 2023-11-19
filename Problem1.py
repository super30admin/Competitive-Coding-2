# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        n=len(nums)
        map={}
        for i in range(n):
            map[nums[i]]=i
        for i in range(n):
            diff=target-nums[i]
            if diff in map.keys():
                if map.get(diff)!=i:
                    return [map.get(diff),i]

        