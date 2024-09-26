def twoSum(nums, target):

    res = {}
    for i in range(len(nums)):

        if (target - nums[i]) in res:
            return [i, res[target - nums[i]]]
        res[nums[i]] = i 
    return [-1, -1]