# Time Complexity: O(N*W) where N is number of items and W is th weight
# Space Complexity: O(W)


def knapSack(W, wt, val, n):
    dp = [0 for i in range(W+1)]  # Making the dp array
  
    # taking first i elements
    for i in range(1, n+1):  

         # starting from back,so that we also have data of
        for w in range(W, 0, -1): 

            # previous computation when taking i-1 items                   
            if wt[i-1] <= w:

                # finding the maximum value
                dp[w] = max(dp[w], dp[w-wt[i-1]]+val[i-1])
  
    return dp[W]  # returning the maximum value of knapsack
  
  
# Driver code
val = [70, 90, 120]
wt = [10, 20, 10]
W = 30
n = len(val)
print(knapSack(W, wt, val, n))