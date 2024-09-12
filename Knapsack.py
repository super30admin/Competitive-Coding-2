"""
Knapsack 1-0 problem
Time Complexity - O(n*m)
Space Complexity - O( n*m)
Created a 2-D array with rows = len(weight)+1 and columns = capacity+1
Created a for loop for rows and columns to enter values for every element
1) row or column = 0 value in dp[row][column] = 0
2) weight[row-1] less than capacity column dp[row][column]  is element in above row
3) if any of these conditions do not satisfy then dp[row][column] = max(value of chosen weight + dp value for balance weight left ,when weight is not choosen)
Last row ,last column gives value of result """
weight = [10,20,30]
values = [60,100,120]
capacity = 50
dp = [[0]*(capacity+1)]*(len(weight)+1)

for row in range(0,(len(weight)+1)):
    for column in range(0,(capacity+1)):
        if column == 0 or row == 0:
            dp[row][column] = 0
        elif weight[row-1] < column:
            dp[row][column] = max(values[row-1] + dp[row-1][column-weight[row-1]], dp[row-1][column])
        else:
            dp[row][column] = dp[row-1][column]
print(dp[len(weight)][capacity])