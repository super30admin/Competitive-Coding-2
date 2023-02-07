
class Solution:
    def maxValue(self, weights: List[int], values: List[int], W: int) -> int:

        #Here we use DP approach. When current jth weight is less than weights available then dp[i-1][j]. 
        #Else we take max of dp[i-1][j] or values[i]+dp[i][j-weights[i]]. If there are 0 elements in weights 
        #and target W is >=0 then we put 0 value gained. Similary if target W=0 and we have wights elements we put 0 value gained. 
        #Space complexity - O(weights*W)
        m = len(weights)
        n = W
        dp = [[0]*(n+1) for i in range(m+1)]

        for i in range(1, m+1):
            for j in range(1, n+1):
                if j<weights[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = max(dp[i-1][j], values[i-1]+dp[i][j-weights[i-1]])


        return dp[m][n]




result = maxValue(7, [1,3,4,5], [1,4,5,7])
print(result)