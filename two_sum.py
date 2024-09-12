
#time complexity: O(N)
#space complexity: O(1)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No


class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        nmap = {}
        for i in range(0, len(nums)):
            complement = target - nums[i]
            if complement in nmap:
                return [nmap[complement], i]
            nmap[nums[i]] = i
        