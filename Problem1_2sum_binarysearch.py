class Solution(object):
    def twoSum(self, nums, target):
        """
        Binary SEarch: Time complexity O(nlogn + nlogn) and space: O(1)
        Note: The idea is to have two pointers one of left and right in a sorted array, 
        take the pointers in a loop because we do the binary for each complement of the
        element. You need to perform binary search make sure to store indices. Use a tuple here
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        nums_sorted = sorted([(num,i) for i, num in enumerate(nums)])
        n = len(nums_sorted)
        for i in range(n):
            l, r = i+1, n-1
            complement = target - nums_sorted[i][0]
            while l<=r:
                mid = (l+r)//2
                if nums_sorted[mid][0]==complement:
                    return [nums_sorted[i][1], nums_sorted[mid][1]]
                elif(nums_sorted[mid][0])<complement:
                    l = mid + 1
                else:
                    r = mid - 1
        return []