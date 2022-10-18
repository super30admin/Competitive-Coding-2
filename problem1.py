# // Time Complexity : O(n x capacity)
# // Space Complexity : O(n x capacity)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No

def problem1(wt, val, Capacity):
    length = len(val)
    arr = [[0 for x in range(Capacity + 1)] for x in range(length + 1)]
    for i in range(length + 1):
        for j in range(Capacity + 1):
            if i == 0 or j == 0:
                continue
            elif wt[i-1] > j:
                arr[i][j] = arr[i-1][j]
            else:
                arr[i][j] = max(arr[i-1][j], val[i-1]+ arr[i-1][j-wt[i-1]])
    return arr[length][Capacity]

value, wt = [60, 100, 120], [10, 20, 30]
capacity = 50
print(problem1(wt, value, capacity))
value, wt = [60, 50, 100, 120], [6, 25, 20, 30]
capacity = 60
print(problem1(wt, value, capacity))
value, wt = [60, 50, 100, 120], [6, 5, 20, 30]
capacity = 60
print(problem1(wt, value, capacity))
value, wt = [1,2,3], [4,5,1]
capacity = 4
print(problem1(wt, value, capacity))
value, wt = [1,2,3], [4,5,6]
capacity = 3
print(problem1(wt, value, capacity))

value, wt = [10, 40, 30, 50], [5, 4, 6, 3]
capacity = 10 
print(problem1(wt, value, capacity))