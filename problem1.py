# Two Sum

# brute force
# Time Complexity: O(n^2)
# Space Complexity: O(1)
def twoSum_1(self, nums, target):
    """
    :type nums: List[int]
    :type target: int
    :rtype: List[int]
    """
    for i in range(len(nums)):
        for j in range(i, len(nums)):
            diff = target - nums[i]
            if nums[j] == diff and i != j:

                return [i, j]

# Optimal
# Time Complexity: O(n)
# Space Complexity: O(1)
def twoSum_2(self, nums, target):
    """
    :type nums: List[int]
    :type target: int
    :rtype: List[int]
    """
    # Optimal
    hmap = {}
    for i in range(len(nums)):
        diff = target - nums[i]
        if diff in hmap:
            return [i, hmap[diff]]
        hmap[nums[i]] = i

    return [-1, -1]
