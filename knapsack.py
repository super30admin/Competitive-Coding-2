# Time Complexity : O(n*cap)
# Space Complexity : O(cap)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : 
# Q- https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/

# Your code here along with comments explaining your approach
#Dp with 1D array most optiomized approach

def knapsack(cap,weight,val,n):

    dp = [0 for i in range(cap+1)]  # Making the dp array
 
    for i in range(1, n+1):  # taking first i elements
        for w in range(cap, 0, -1):  # starting from back,so that we also have data of
                                # previous computation when taking i-1 items
            if weight[i-1] <= w:
                # finding the maximum value
                dp[w] = max(dp[w], dp[w-weight[i-1]]+val[i-1])
 
    return dp[cap]
val = [60, 100, 120]
weight = [10, 20, 30]
cap = 50
n = len(val)

print (knapsack(cap, weight, val,n))
 