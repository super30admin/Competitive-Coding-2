# Knapsack problem solved through DP 

def knapsack(weights , profits, target):
    """
    weigths = list of size(n); weight > 0 
    profits = list of size(n); profit > 0
    target = integer value 

    return the max profit  
    coins on the x-axis, amt on the y axis 

    """
    if len(weights) ==0: return 0 # nothing to fill in the knapsack
    if target ==0 : return 0  


    dp = [ [0]*(1 +target)  for _ in range(1+len(weights)) ]        
    for i in range(1,len(weights)+1) :
        weight = weights[i-1]               # weight is under consideration
        for j in range(1, (1+target) ):
            capacity = j
            if  weight > capacity:
                dp[i][j]= dp[i-1][j] ; 
            else :
                dp[i][j] = max( (profits[i-1]+dp[i-1][capacity-weight]) ,  dp[i-1][j] ) ; 
    # print(dp)
    print("\n")

    return dp[-1][-1]


w1 = [10, 20, 30]
p1 = [ 85,60, 70] 
print(knapsack(w1, p1, 10))

wk = [1, 2, 3]
pk = [5, 2, 6]
print(knapsack(wk, pk, 10))

wk = [1, 2, 3, 8, 7, 4]
pk = [8, 5, 2, 6, 7, 2]
print(knapsack(wk, pk, 10))






# dp[i][j] = max( dp[i-1][j] , profit(i-1) +dp[j-1][capa
# city-weight] )

# if remainingCapacity ==0:
#     t = j+1
#     while t < len(dp[0]:

#         dp[i][t] = dp[i][j]
#         t += 1
