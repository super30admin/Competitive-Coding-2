# Time Comlpexity: O(n)
# Space Complexity: O(1)
class Solution(object):
    def findClosestElements(self, arr, k, x):
        """
        :type arr: List[int]
        :type k: int
        :type x: int
        :rtype: List[int]
        """
        #curr = 0
        l = 0
        r = len(arr) - 1
        while r-l+1 > k:
            if abs(arr[l] - x) < abs(arr[r] - x):
                r -= 1
            elif abs(arr[l] - x) > abs(arr[r] - x):
                l += 1
            else:
                r -= 1
        return arr[l:r+1]
