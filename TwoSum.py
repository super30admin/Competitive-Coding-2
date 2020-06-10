class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        result = []
        dictChecker = {}

        for index, number in enumerate(nums):
            numberToCheck = target - number
            if numberToCheck not in dictChecker.keys():
                dictChecker[number] = index
            else:
                return [dictChecker[numberToCheck], index]

        return [-1, -1]