class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        # map = dict()
        # try:
        #     for i in range(len(nums)):
        #         if target-nums[i] not in map:
        #             map[nums[i]] = i
        #         else:
        #             return [map[target-nums[i]], i]
        # except:
        #     print("Given an invalid input")
        # return [-1, -1]
        map = dict()
        for i in range(len(nums)):
            map[nums[i]] = i
        for i in range(len(nums)):
            if (target-nums[i] in map) and (map[target-nums[i]]-i)>=1:
                return [i, map[target-nums[i]]]
        return [-1,-1]

""" Time complexity - O(n)
Space Complexity - O(n) as n elements can be the keys in worst case"""