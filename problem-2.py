#O-1 Knapsack
#Space ComplexityL O(n)
#timecomplexity: O(m*n) where m is the capacity size and n is the number of items 
​
def knapSack(capacity, wt, profits):
    dp = [0 for i in range(capacity+1)]
    n = len(profits) 
 
    for i in range(1, n+1): 
        for w in range(capacity, 0, -1):  # starting from back,so that we also have data of
                                # previous computation when taking i-1 items
            if wt[i-1] <= w:
                # finding the maximum value
                dp[w] = max(dp[w], dp[w-wt[i-1]]+profits[i-1])
 
    return dp[capacity]  # returning the maximum value of knapsack
 
 
# Driver code
profits = [60, 100, 120]
wt = [10, 20, 30]
capacity = 50
​
​
print(knapSack(capacity, wt, profits))