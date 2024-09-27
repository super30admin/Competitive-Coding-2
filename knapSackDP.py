# // Time Complexity : O(M*N)
# // Space Complexity : O(M*N)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :


# // Your code here along with comments explaining your approach

def knapSack(value,weights,capacity):
    dp = [[0 for _ in range(capacity+1) ] for _ in range(len(weights)+1)] 
    
    for i in range(len(weights)+1):
        for j in range(capacity+1):
            if i == 0 or j == 0:
                dp[i][j] = 0;
            
            elif j < weights[i-1]:
                dp[i][j] = dp[i-1][i]
            else:
                dp[i][j] = max(dp[i-1][i], dp[i-1][j -weights[i-1]]+value[i-1])
       
    return dp[len(weights)][capacity]

value = [60,100,120]
weights = [10,20,30]
capacity = 50
print(knapSack(value,weights,capacity))


