# Time Complexity : O(len(values)*len(weights))
# Space Complexity : O(len(values)*len(weights))
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    #Recursive solution 2 raised to n complexity
    def knapsack(self,values,weights,n,W):
        if W<0:
            return -1
        
        if n<0 or W==0:
            return 0
        
        # Check for the case where you choose to include the current item 'n'
        # You include it and then add that value to the value which will be returned when you recur for reduced weight
        # W-weights[n] and values[n-1]

        include= values[n]+ self.knapsack(values,weights,n-1,W-weights[n])

        # If you exclude current item then you will check for values[n-1] and same weight

        exclude=self.knapsack(values,weights,n-1,W)

        return max(include,exclude)


    # DP Solution
    def knapSack(self,values, weights, n, W):
        dp = [[0 for x in range(W + 1)] for x in range(n+1)]
        
        for v in range(n+1):
            for w in range(W+1):
                if v==0 or w==0:
                    dp[v][w]==0
                elif weights[v-1]<=w:
                    dp[v][w]=max(values[v-1]+dp[v-1][w-weights[v-1]],dp[v-1][w])
                else:
                    dp[v][w]=dp[v-1][w]
        
        return dp[v][w]





obj=Solution()
values = [60, 100, 120]
weights = [10, 20, 30]
W = 50
print(obj.knapsack(values,weights,len(values)-1,W))
print(obj.knapSack(values,weights,len(values),W))
