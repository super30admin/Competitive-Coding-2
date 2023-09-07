# 2sum
# Time Complexity: O(n)
# Space Complexity: O(n)
nums = [7,9,2,3,4,5]
target = 7
hmap = {}

for i in range(len(nums)):
    if target - nums[i] in hmap:
        print(i,hmap[target- nums[i]])
    else:
        hmap[nums[i]] = i

