'''
TC: O(m*n) where m and n are the len(weights) and capacity respectively
SC: O(n) where it is the capacity row that we created as a dp array
'''
def knapsack(weights, profits, capacity):
    dp = [0 for _ in range(capacity+1)]
    for j in range(capacity+1):
        if weights[0] > j:
            dp[j] = 0
        else:
            dp[j] = profits[0]
            
    for i in range(1, len(weights)):
        temp = []
        for j in range(0, capacity+1):
            if weights[i] > j:
                temp.append(dp[j])
            else:
                temp.append(max(dp[j], dp[j-weights[i]] + profits[i]))
        dp = temp
    return dp[-1]
    
print(knapsack([4,5,1,3], [1,2,3,2], 4))
print(knapsack([1,2,3], [10,15,40], 6))