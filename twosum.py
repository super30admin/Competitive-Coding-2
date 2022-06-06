#Time complexity:O(n)
#Space complexity: O(n)
def twosum(nums,target):
    d={}
    for i in range(len(nums)):
        if nums[i] not in d:
            d[nums[i]]=i
        if target-nums[i] in d and i!=d[target-nums[i]]:
            return i, d[target-nums[i]]
res=twosum([3,3],6)
print(res)


