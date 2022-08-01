# Time Complexity : O(n*m) where n = len(weight) and m = capacity of the knapsack
# Space Complexity : O(n*m) for the 2D DP matrix
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


def solution(weight,value,capacity):
    if len(weight)!=len(value):
        return # In case weights and values have different number of objects
    n = len(weight) # Number of objects i.e length of 
    dp = [[None for i in range(capacity+1)] for j in range(n+1)] # Create DP array of n+1 rows and capacity+1 columns
    for i in range(len(dp)):
        dp[i][0] = 0 # Initialize all rows' 0th element as 0
    for j in range(len(dp[0])):
        dp[0][j] = 0 # Initialize all columns' 0th element as 0
    
    for i in range(1,n+1):
        for j in range(1,capacity+1):
            if weight[i-1] > j: # If weight of current object is less than j then copy value above it in DP matrix
                dp[i][j] = dp[i-1][j]
            else:
                dp[i][j] = max(dp[i-1][j], value[i-1]+dp[i-1][j-weight[i-1]]) # Find the max of the value in the previous row (for case not selected current obj) and value of current weight added to the DP array value at j-weight of current chosen weight (for case of selecting current obj)
    # print(dp)
    return dp[len(dp)-1][len(dp[0])-1] # Ans is found at the last element of the matrix

weight = [1,3,4,5]
value = [1,4,5,7]
capacity = 7
print(solution(weight,value,capacity))

value = [60,100,120]
weight = [10,20,30]
capacity = 50
print(solution(weight,value,capacity))