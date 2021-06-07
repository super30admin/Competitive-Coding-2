def twoSum(nums, target):
    dic = {}

    for i in range(len(nums)):
        if target - nums[i] in dic:
            return dic.get(target-nums[i]), i

        if nums[i] not in dic:
            dic[nums[i]] = i



ret1,ret2 = twoSum([2,7,11,15], 18)

print(ret1,ret2)