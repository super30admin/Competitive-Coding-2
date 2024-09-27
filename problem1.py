class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        hashmap = {}

        for i in range(len(nums)):
            if target - nums[i] in hashmap:
                return [hashmap[target - nums[i]],i]
            if nums[i] not in hashmap:
                hashmap[nums[i]] = i
            

        return [-1,-1]

#Time complexity is O(n) since we are iterating over each element in the array
#Space complexity is O(n) where n is length of the array and each element is unique
#Brute force solution could be linear iteration with O(n^2) TC and O(1) SC