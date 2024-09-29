'''
    Time Complexity: O(n)
    Space Complexity: O(n)
    Ran successfully on leetcode
    Approach: Maintained a hashmap to store the complements and its corresponding index required for each number. 
            For any number check if the complement is explored before and return the current index and complement's index.
'''
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        hashMap = {}

        for i in range(len(nums)):
            complement = target - nums[i]

            if complement in hashMap:
                return [hashMap[complement], i]
            else:
                hashMap[nums[i]] = i

        return []