# Time Complexity : O(m*n) m is target and n is length of weights
# Space Complexity : O(m*n) m is target and n is length of weights
# Did this code successfully run on Leetcode : Problem is not there on leetcode
# Any problem you faced while coding this : No

def maxValues(values,weights,target):
    arr = [[0 for i in range(target+1)] for j in range(len(values)+1)] #creating the array of size len(weights)+1 * target+1
    for i in range(1,len(arr)): #iterating through the array
        for j in range(1,len(arr[0])):
            if weights[i-1] > j: # if current weight is greater than capacity
                arr[i][j] = arr[i-1][j]
            else:
                arr[i][j] = max(arr[i-1][j], values[i-1]+ arr[i-1][j - weights[i-1]]) # max of considering and not considering the present weight, for not considering copy from above bucket of weights
                # for considering take the value for current weight and add take the remaining weight as capacity from previous bucket
    return arr[len(arr)-1][len(arr[0])-1]


print(maxValues([60,100,120],[10,20,30],50))
