# recursive solution
class Solution:
    def rec(self, w, v, capacity):
        if not w:
            return 0
        
        if len(w) != len(v):
            return 0
        
        return self.helper(w, v, capacity, 0, 0)
    
    def helper(self, w, v, capacity, index, profit):
        # base case
        if capacity == 0 or index>=len(w):
            return profit
        
        
        # choose
        if (capacity - w[index]>=0):
            case1 = self.helper(w,v,capacity-w[index], index+1, profit+v[index])
        else:
            case1 = self.helper(w,v,capacity, index+1, profit)
        
        case2 = self.helper(w,v,capacity, index+1, profit)
        return max(case1, case2)


#DP
class Solution:
    def ans(self, w, v, capacity):
        m = len(w)+1
        n = capacity + 1
        
        dp = [[0 for i in range(n)] for j in range(m)]
        
        for i in range(1, m):
            for j in range(1, n):
                if j<w[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = max(dp[i-1][j], dp[i-1][j-w[i-1]]+v[i-1])
                    
        return dp[-1][-1]

# TC: O(MN) SC: O(MN)
# solution is just like coin change, but this is bounded (non-repeating) and 
# considering values with weights in the formula