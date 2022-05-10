#time complexity: O(n)
#Space complexity: O(n)
def TwoSum(nums,target):
    dict1={}
    for i in range(len(nums)):
        if target-nums[i] in dict1:
            return [dict1[target-nums[i]],i]
        dict1[nums[i]]=i
    return [-1,-1]

nums=[1,2, 3 ,9, 3]
target=6
print(TwoSum(nums,target))