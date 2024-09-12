# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : 

# Your code here along with comments explaining your approach
def twosum(nums,target):
    dict = {}
    for i,n in enumerate(nums):
        diff = target - n
        if diff in dict:
            return [dict[diff],i]
        dict[n] = i
    return

nums = [2,7,11,15]
target = 9
print(twosum(nums,target))