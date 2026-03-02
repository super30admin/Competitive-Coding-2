#Two Sum

#Time complexity -> On
#Space complexity -> On
#Logic -> check if the compliment (target-current num) if the num we are iterating on is present in dict. If present they both can make the target so return the index


class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        numToIndex = {}
        for i in range (0, len(nums)):
            num = nums[i]
            complement = target - num
            if complement in numToIndex:
                return [numToIndex[complement], i]
            
            numToIndex[num] = i

        return -1
