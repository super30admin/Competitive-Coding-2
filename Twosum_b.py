class TwoSum(object):
    '''
    Time Complexity: O(n)
    Space Complexity: O(n)
    '''

    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        if nums is None or len(nums) < 2:
            return []

        numMap = {}  # HashMap to store number and its index

        for i, num in enumerate(nums):
            complement = target - num
            if complement in numMap:
                # Return indices of complement and current number
                return [numMap[complement], i]
            numMap[num] = i  # Store current number and its index in the HashMap

        return []  # No solution found, return an empty list
