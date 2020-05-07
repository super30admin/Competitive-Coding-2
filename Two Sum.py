#1. Two Sum
#Tc- O(n)
#SC-> O(n)


class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        myDict = {}
        for index , value in enumerate(nums): 
            difference = target-value 
            if difference in myDict.keys():
                return[myDict[difference],index]
            myDict[value] = index 