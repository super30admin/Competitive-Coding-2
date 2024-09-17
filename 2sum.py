# Space = O(n)
# Time complexity = O(n)
# Works on leetcode
def twosum(arr,target):
    index = {}
    for i,val in enumerate(arr):
        if target-val in index:
            return [index[target-val],i]
        else:
            index[val]=i
    return [-1,-1]
