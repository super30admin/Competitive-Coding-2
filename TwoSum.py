# Time Complexity: O(n)
# Space Complexity: O(n)

class Solution:
    def twoSum(self, nums: list[int], target: int) -> list[int]:
        result = []
        myDict = {}

        if nums == None or len(nums) == 0:
            return [-1,-1]

        for i in range(len(nums)):
            diff = target - nums[i] # index=1 value = 7 diff = 2

            if nums[i] in myDict: 
                result.append(myDict[nums[i]]) # value 0
                result.append(i) # 1
                return result # [0,1]

            myDict[diff] = i # {7:0}

        return [-1,-1]