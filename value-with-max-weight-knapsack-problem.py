# TC: O(n)
# SC: O(n)
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        hashmap = {}
        # res = []
        for ind in range(len(nums)):
            ele = nums[ind]
            if ele not in hashmap:
                hashmap[ele] = ind
            comp = target - ele
            if comp in hashmap and ind != hashmap[comp]:
                return [ind, hashmap[comp]]