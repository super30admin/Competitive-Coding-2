def twosum(nums,target):
    dict = {}
    for i, num in enumerate(nums):
        diff = target - num
        if diff in dict:
            return [i,dict[diff]]
        dict[num]  = i

nums = [2,7,11,15]
target = 9
print(twosum(nums,target))

