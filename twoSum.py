def twoSum(array, target):
    nums = {}
    for x in array:
        if target - x in nums:
            return [x, target - x]
        else:
            nums[x] = True
    return []

print(twoSum([3,5,-4,8,11,1,-1,6], 10))