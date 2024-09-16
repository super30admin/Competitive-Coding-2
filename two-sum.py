# Time Complexity: O(n)
# Space Complexity: O(n)
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        nmap=dict()
        for i in range(len(nums)):
            if target-nums[i] in nmap:
                return [nmap[target-nums[i]],i]
            nmap[nums[i]]=i