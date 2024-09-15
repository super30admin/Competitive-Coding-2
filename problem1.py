#2sum


# // Time Complexity : O(N)
# // Space Complexity :O(N)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


def twoSum(nums, target):
    if nums ==[]:
        return -1
    hashmap={}
    for i in range(len(nums)):
        diff = target - nums[i]
        if diff in hashmap:                     #if the difference of the target and current element is in the hashmap, then return the current index and the value of the difference in the hashmap
            return [hashmap[diff], i]
        else:                                   #if the difference is not in the hashmap, then store the current element and its index into the hashmap
            hashmap[nums[i]]= i
    return -1

#test
nums = [2, 7, 11, 15]
target = 9

print(twoSum(nums, target))

nums = [2, 7, 11, 4, 15]
target = 11

print(twoSum(nums, target))
