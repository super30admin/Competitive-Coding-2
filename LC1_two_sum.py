#  Time Complexity : O(n)
#  Space Complexity : O(n)
#  Did this code successfully run on Leetcode : yes
#  Any problem you faced while coding this : No

# Approach: Store each visited number with its index in a hash map, so you can quickly find the index of the complement needed to reach the target

def twoSum(self, nums: List[int], target: int) -> List[int]:
    hMap={}
    for i in range(len(nums)):
        diff=target-nums[i]
        if(diff in hMap):
            return [hMap[diff], i]
        else:
            hMap[nums[i]]=i 
    return -1