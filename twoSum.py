# // Time Complexity : O(n)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No
 
#  Approach: Putting compliments in hashtable with indexes as values, we can identify if the next element's value is equal to the compliment: if it is, we return the current index and the compliment's index, else we put in the new key value pair and iterate through the entire array

def calcSum(nums, target):

    hmap = {}
    comp = 0

    if len(nums) == 0:
        return [-1,-1]

    for i in range(len(nums)):

        comp = target - nums[i]
        # extra condition that checks that the values at both elements are unequal eg. 2+2 = 4 then we shouldn't return the indices of these elements.
        if nums[i] in hmap.keys() and comp != nums[i]:
            return [hmap[nums[i]], i]

        else:
            hmap[comp] = i


nums = [2,2,3,1]
target = 4
print(calcSum(nums, target))