"""
Time Complexity : O(N)
Space Complexity : O(N)
Did this code successfully run on Leetcode : yes
Any problem you faced while coding this : no
"""
def twoSum(nums , target):

    hashmap = {}
    for index, element in nums:

        complement = target - element
        if(complement in hashmap):
            return [hashmap[complement] , index]

        hashmap[element] = index
