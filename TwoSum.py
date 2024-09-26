# Time Complexity : O(n)
# Space Complexity : O(n) for the dictionary
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this :

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        dictChecker = {}

        for index, number in enumerate(nums):
            numberToCheck = target - number
            if numberToCheck not in dictChecker.keys():
                dictChecker[number] = index
            else:
                return [dictChecker[numberToCheck], index]

        return [-1, -1]