#Time Complexity: O(n)
#Space Complexity: O(n)
#Did it run on leetcode: Yes

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        hashmap = {}
        for index in range(len(nums)):
            complement = target - nums[index]
            if complement in hashmap:
                return [hashmap[complement], index]
            else:
                hashmap[nums[index]] = index
        return [-1, -1]