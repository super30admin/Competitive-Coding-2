# Time Complexity : O(n) where n is the number of elements in the list
# Space Complexity : O(n) for the hashMap
# Did this code successfully run on Leetcode :  yes
# Any problem you faced while coding this : no


# we create a hashMap to keep track of target - element and element position
# if the current element already present in the key of the hashMap
# then its corresponding position will be its pair to get the target sum.
# else we will return empty list

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:

        hashMap = {}

        for num in range(len(nums)):

            if nums[num] in hashMap.keys():

                return [hashMap[nums[num]], num]

            else:

                key = target - nums[num]

                hashMap[key] = num

        return []
