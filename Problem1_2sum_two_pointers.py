class Solution(object):
    def twoSum(self, nums, target):
        """
        Two pointers: Time complexity O(nlogn) and space: O(1)
        Note: The idea is to have two pointers one of left and right in a sorted array.
        You need to add elements in left and right and check if its less or greater than
        target. If greater than target r-- and if lesser than target l++, make sure to 
        store indices. Use a tuple here
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        nums_sorted = sorted([(num,i) for i, num in enumerate(nums)])
        n = len(nums_sorted)
        l, r = 0, n-1
        while l<=r:
            if(nums_sorted[l][0]+nums_sorted[r][0])>target:
                r-=1
            elif(nums_sorted[l][0]+nums_sorted[r][0])<target:
                l+=1
            else:
                return [nums_sorted[l][1],nums_sorted[r][1]]
        return []