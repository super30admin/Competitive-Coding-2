# -*- coding: utf-8 -*-
"""
Created on Sat Dec 14 15:45:18 2019

@author: gunjan
"""

nums = [2, 7, 11, 15]
target=9

#bruteforce method
for i in range(0, len(nums)-1):
    for j in range(i+1, len(nums)):
        if nums[i]+nums[j]==target :
            print nums[i], "and",nums[j], "=", target
            break

#TC=O(n^2)
#SC=O(1)

###################################################################
#hashmap method
arr = [1, 4, 45, 6, 10, 8] 
arr_size=len(arr)
sum = 16

keys=arr
values=list(range(len(arr)))

dictionary = dict(zip(keys, values))
print(dictionary)

for i in range(0, arr_size):
    complement=sum-arr[i]
    if dictionary.has_key(complement) and dictionary.get(complement)!=i :
        print arr[i], complement #numbers
        print i, dictionary.get(complement)#indexes
        


#TC=O(n)
#SC=O(n)