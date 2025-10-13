// Time Complexity =O(n)
// Space Complexity = O(n)

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        hashmap = {}
        for i in range(len(nums)):
            comp = target - nums[i]
            if comp in hashmap.keys():
                return [i,hashmap[comp]]
            hashmap[nums[i]] = i