"""
TC  O(N*C). 
where 'N'is the number of weight element and 'C' is capacity. As for every weight element we traverse through all weight capacities 1<=w<=C.
SC O(N*C). 
The use of 2-D array of size 'N*C'.
"""


# A Dynamic Programming based Python
# Program for 0-1 Knapsack problem
# Returns the maximum value that can
# be put in a knapsack of capacity C
 
 
def knapSack(cap, wts, vals):
    dp = [[0 for _ in range(cap+1)] for _ in range(len(wt)+1)]   # or we can do range(val+1) for 2nd loop
    print(dp)
    for i in range(1,len(wts)+1):  # i is current wt (or val)
        for j in range(1,cap+1):  # j is curr capacity
            if wt[i-1] <= j:  # if current weight is less than curr capacity
                # take max of currentVal+value from previous row and column, where column is calculated based on remaining capacity
                # j-wt[i-1]. In english we are saying if we take current weight, then take its value and for whatever is remaining capacity
                # take value from previous row and column equal to remaining capacity. E.g. if curr wt is 3, capacity is 4, then we take curr wt value +
                # remaining cap 1, so look at what is the best we were able to do in previous row when we had capacity 1. Now compare that to previous row, and column eq
                # curr capacity, meaning if we didn't take current weight, what is the best we had in previous column.
                dp[i][j]= max(val[i-1]+dp[i-1][j- wt[i-1]], dp[i-1][j])
            else:
                # since capacity is less that current weight, just get value from previous row and same column
                dp[i][j]= dp[i-1][j]
    print(dp)
    return dp[len(wt)][cap]

# Driver code
val = [10,15,40]
wt = [1,2,3]
cap = 6
# n = len(val)
print(knapSack(cap, wt, val))