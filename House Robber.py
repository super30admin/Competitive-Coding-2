#Time Complexity: O(len(nums))
#Space Complexity: O(1)
class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        taken = 0
        not_taken = 0
        mx = -sys.maxint
        for i in range(1, len(nums)+1):
            prevnottaken = not_taken
            not_taken = max(taken, not_taken)
            taken = nums[i-1]+prevnottaken
            if mx< max(taken, not_taken):
                mx = max(taken, not_taken)
        return mx
