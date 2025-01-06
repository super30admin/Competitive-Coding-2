class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        # TC: O(n)
        # Sc: O(n)
        # Used the concept of hashmap for finding the indices of numbers

        if nums is None or len(nums) == 0:
            return [-1,-1]
        hmap = {}
        for i in range(len(nums)):
            diff = target-nums[i]
            if diff in hmap.keys():
                if hmap[diff] != i:
                    return [hmap[diff],i]
            else:
                hmap[nums[i]] = i
        return [-1,-1]