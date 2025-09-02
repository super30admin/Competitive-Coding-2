# profits array = [8,2,10]
# weights array = [1,2,4]
# weight capacity = 4

# two condtions :
# 1st is weights < weigth capacity
# profist with max 
# greedy approach is : find the max values in the profist array and add them to get the max profit but the weights of these values can be crossing the weight capacity ( so not a valid solution)
# optimal way : taking a matrix, where rows is the items, cols is the capacity ( from 0 to capacity)
# capacity            0   1   2    3    4
# items
# 0 items           [ 0   0   0    0    0 ]
# 1st item (1,8)    [ 0   8   8    8    8 ] # max profit with this item
# 2nd item (2,2)    [ 0   8   8   10   10 ]
# 3rd item (3,10)   [ 0   8   8   10   18 ]

#dp[2][1] = ( as weight of item2 is greater than 1 here so we take the previous earnings) = dp[1][1]
# dp[2][2] = max of (previous earnings dp[1][2], price[of this item]+ dp of the max profit for the rest of weigth with the previous item= dp[1][4-w[1]->2]) = max (dp[1][2], price[1] + dp[1][2])

# tc = O(n*m) n is the len of prices, m is the weight capacity
# sc = O(n*m) 

def  my_function(prices,weights,capacity):
    n = len(prices)
    dp = [[0] * (capacity + 1) for _ in range(n + 1)]
    
    for i in range(1, n + 1):
        for w in range(1, capacity + 1):
            if weights[i-1] <= w:
                dp[i][w] = max(
                    dp[i-1][w],  # skip item
                    prices[i-1] + dp[i-1][w - weights[i-1]]  # take item
                )
            else:
                dp[i][w] = dp[i-1][w]
    
    return dp[n][capacity]
