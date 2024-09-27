# Time Complexity : O(n), where n is the length of nums
# Space Complexity : O(n), where n is the length of nums
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

# Your code here along with comments explaining your approach
class Solution(object):
    # for every value in array calculate complement by subtracting value from target.
    # If the complement is in the hashmap return both the indexes,
    # otherwise store value and index in hashmap.
    def twoSum(self, nums, target):
        if not nums:
            return [-1, -1]
        store = {}
        for idx, elem in enumerate(nums):
            diff = target - elem
            if diff in store:
                return [store[diff], idx]
            store[elem] = idx
        return [-1, -1]

print(Solution().twoSum([7,2,5,1,9], 16))
