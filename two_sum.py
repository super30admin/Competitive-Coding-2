class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        """
        :rtype: int
        :time complexity : O(1)
        :space complexity : O(n)
        """
        di = dict()
        for i, num in enumerate(nums):
            rem=target-num
            if rem in di:
                return i, di[rem]
            else:
                di[num]=i
        return
                