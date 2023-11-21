profits=[10,15,40]
weights=[1,2,3]
capacity=4

# def knapsack(weights,i,capacity,profit):
#     if capacity==0 or i==len(weights)-1:
#         return profit
    
#     knapsack(weights,i+1,capacity,profit)
#     knapsack(weights,i+1,capacity-weights[i],profit+profits[i])
    
# print(knapsack(weights,0,total_capacity,0))

dp=[[0 for i in range(0,capacity+1)] for j in range(0,len(weights)+1)]

for i in range(1,len(weights)+1):
    for j in range(1,capacity+1):
        if j<weights[i-1]:
            dp[i][j]=(dp[i-1][j])
        elif j-weights[i-1]>=0:
            dp[i][j]=max(dp[i-1][j],dp[i-1][j-weights[i-1]]+profits[i-1])
            
print(dp)
print(dp[len(weights)][capacity])
        
        
        



    

