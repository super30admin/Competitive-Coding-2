# Time Complexity : O(N)
# Space Complexity : O(N) 
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : NO

def findPair(arr,t):
    if len(arr)==0:
        return (-1,-1)

    hashmap = {}

    for i in range(len(arr)):
        if t-arr[i] not in hashmap.keys():
            hashmap[arr[i]] = i 
        else:
            return  (hashmap[t-arr[i]],i)



arr = [-3,4,5,6,8]
t = 3
print(findPair(arr,t))