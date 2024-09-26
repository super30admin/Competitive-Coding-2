class Solution(object):
    def knapSack(self,W, wt, val, n):
        dp = [0 for i in range(W+1)]  # creating dp in array
    
        for i in range(1, n+1):  # taking first i elements

                # starting from back of array, while we're writing an entry in a row, 
                # the inner loop has to be reversed is because when we use dp[w-wt[i-1]],
                #  we need the value from the previous iteration of outer loop.
            for w in range(W, 0, -1): 
                if wt[i-1] <= w:
                    # finding the maximum value
                    dp[w] = max(dp[w], dp[w-wt[i-1]]+val[i-1])
    
        return dp[W] 

val = [10, 15, 40]
wt = [1, 2, 3]
W = 50
n = len(val)
obj = Solution()
print(obj.knapSack(W, wt, val, n))
