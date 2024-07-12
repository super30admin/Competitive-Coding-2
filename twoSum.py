class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        myDict = {}
        for i in range(len(nums)):
            if target-nums[i] in myDict:
                return [myDict[target-nums[i]],i]
            else:
                myDict[nums[i]] = i

# Time Complexity: O(n)
# Space Complexity: O(n)
        
