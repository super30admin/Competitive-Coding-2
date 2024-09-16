#Searching and Inserting into hashMap is O(1) for for n length array, the TC and SC is O(n)


def twosum(nums,target):
    hash1={}

    for i,val in enumerate(nums):
        diff=target-val
        if diff in hash1:
            return [hash1[diff],i]
        hash1[val]=i