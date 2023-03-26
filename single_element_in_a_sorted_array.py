# Time Complexity : O(logn) because we are using binary search
# Space Complexity : O(1) because we are not using any extra space
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
"""
In this code we are using binary search to find the single element in the array.
"""

class Solution:
    def singleNonDuplicate(self, nums: List[int]) -> int:

        low = 0
        high = len(nums) -1

        while low < high:
            mid = (low+high)//2
            if mid %2 == 1:
                mid -=1

            if nums[mid] != nums[mid + 1]:
                high = mid
            else:
                low = mid + 2
        
        return nums[low]