'''
Time Complexity :O(n)
Space Complexity: O(n)
Did this code successfully run on Leetcode : Yes
Explanation:
Find the complement of the array and after find thing the complement, check if complement in hashmap, if it exists return
index in hashmap and current index. Also add the current nums[i] in the hashmap
'''
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        if nums == None or len(nums) == 0:
            return []

        mydict = {}

        for i in range(0, len(nums)):
            complement = target - nums[i]

            if complement in mydict.keys():
                return [mydict[complement], i]

            if nums[i] not in mydict.keys():
                mydict[nums[i]] = i

        return []