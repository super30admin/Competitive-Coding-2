#time complexity: O(n)
#Space complexity O(n)
class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        # Hashmap with element and index
        res = {}
        for idx,el in enumerate(nums):
            if target-el in res:
                return idx,res[target-el]
            res[el] = idx
            