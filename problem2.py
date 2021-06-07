#Two sum
nums=[2,7,11,15]
target=9
d = {}
for i in range(len(nums)):
    if target - nums[i] in d:
        print([i, d[target - nums[i]]]) 
    else:
        d[nums[i]] = i
