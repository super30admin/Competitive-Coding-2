# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Iterate over nums to store the number seen till now in an hashmap with their indexes
# Check if the toatl tarrget minus current value has been seen before, if yes, return that previous index and the current one.


from typing import List
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        previous={}
        for i,n in enumerate(nums):
            rem=target-n
            if rem in previous:
                return [previous[rem],i]
            else:
                previous[n]=i

obj=Solution()
nums = [2,7,11,15]
target = 9
print(obj.twoSum(nums,target))

