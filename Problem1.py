weight =[10,20,30]
values = [60,100,120]
wt= 50
n = len(weight)

#Initializing 2D Matrix with rows as weight and cols as req weight (from 0 to 50)
dp= [[0 for i in range(wt+1)]for j in range(n+1)]



for i in range(n+1): #iterating through rows
    for j in range(wt+1): #iterating through cols
        if i==0 or j ==0:
            dp[i][j]==0  #base case for first row and first column
        elif weight[i-1]<=j: # if current value is less than overall capacity, then we compare with value with and without current value
                            #and then store the max of the two 
            dp[i][j] = max(values[i-1]+dp[i-1][j-weight[i-1]], dp[i-1][j])
        else: #if current value is more than the overall capacity, we just initialize last value
            dp[i][j] = dp[i-1][j]
    



            
print( dp[-1][-1])
            
            
