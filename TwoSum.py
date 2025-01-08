# Time Complexity : O(n), where n is the number of elements
# Space Complexity : O(n), because we aree storing remaining sum keys in a hashmap (search complexity is now O(1))
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA 

# Your code here along with comments explaining your approach:
# we check for each number, how much more we need to get the target sum
# now for if we have seen this remaining sum in our list, we will return these 2 numbers' indices
# else we will add the current remaining sum to the hash map


class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        if nums is None:
            return [-1, -1]
        
        hmap = {}

        # using hashing to calculate the remaining sum
        for i in range(len(nums)):
            # remaining sum is target - current num
            rSum = target - nums[i]
            
            # so we check if the remaining sum exists in the map

            # if the key exists in the map
            if rSum in hmap:
                # we just return it's index and the current num's index - because they both add up to make the target
                return [hmap[rSum], i]
            
            # the key is the thing we are trying to search - remaining sum
            # and the value is the index, the thing we need to return
            hmap[nums[i]] = i
        
        return [-1, -1]