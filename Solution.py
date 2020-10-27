"""
Time complexity=O(n)
Space Complexity is O(n)

-Find complement with current value index and target. If present return it from dictionary.
-Else add them to dictionary as value as their index.

"""




class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        dict_index={}
        for i in range(len(nums)):
            if nums[i] in dict_index.keys():
                return [dict_index[nums[i]],i]
            else:
                dict_index[target-nums[i]]=i