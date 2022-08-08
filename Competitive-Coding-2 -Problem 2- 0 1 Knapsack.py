"""
S30 FAANMG Problem #30 {Medium}

0-1 Knapsack Problem | DP-10

Time Complexity : O(MN)

m = No of elements in the Weight
n = Capacity 

Space Complexity : O(MN)


Did this code successfully run on Leetcode : Yes
  

We are using a 2D matrix to store the maximum value in the capacity

for each cell we will check the max of the previous value at the dp[i-1][j] place with 
the current value + the dp[i-1][j - weights[i-1]
  

@name: Rahul Govindkumar_RN27JUL2022
"""



weights=[10, 20 , 30]
values= [60, 100,120]
capacity = 70
m = len(weights)   #row
n = capacity       # col

dp = [[0]*(n+1) for _ in range (m+1)]
for i in range (1, len(dp)):
    for j in range (len(dp[0])):
        
        if(j < weights[i-1]):
            dp[i][j] = dp[i-1][j]
        else:
            dp[i][j]= max( dp[i-1][j], values[i-1] + dp[i-1][j - weights[i-1]])
            
print(dp[m][n])