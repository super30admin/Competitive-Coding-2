# Time Complexity: O(n)
# Space Complexity: O(n)
class Solution(object):
    def twoSum(self, nums, target):
        #         Map to maiantain the current number and its index
        map_list = {}

        #     Iterate over array to get the two numbers which will ad up to target
        for i in range(len(nums)):
            #         Take the next rquired number we need to find i.e target - current value
            comp_numb = target - nums[i]
            #      if the complementry number is already present in map we are maintaing return
            #      its index and curren tnumber index
            if map_list.has_key(comp_numb):
                return [map_list.get(comp_numb), i]
            #         or else add the current element of an array with its iindex in map
            else:
                map_list[nums[i]] = i

        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
