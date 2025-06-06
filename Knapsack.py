# 0/1 Knapsack Problem 
''' 
Approach: Dynamic Programming
Time Complexity: O(n*w)
Space Complexity: O(n*w)

'''

# Approach: Recursion  
# Time Complexity: O(2^n)
# Space Complexity: O(H) recursive stack 

class Solution:
    def knapsack(self, W, val, wt):
        # code her
        
        def solve(i, remaining_capacity):
            if i == len(wt):
                return 0
                
            res = -1 
            if remaining_capacity-wt[i] >= 0:
                res = max(res, val[i]+solve(i+1, remaining_capacity-wt[i]))
            
            res = max(res, solve(i+1, remaining_capacity))
            
            return res
        
        return solve(0, W)

# Approach: Dynamic Programming Tabulation
# Time Complexity: O(n*w)
# Space Complexity: O(n*w)

class Solution:
    def knapsack(self, W, val, wt):
        # code her
        
        dp = [[-1 for _ in range(W+1)] for _ in range(len(wt))]
        
        def solve(i, remaining_capacity):
            if i == len(wt):
                return 0
            if dp[i][remaining_capacity] != -1:
                return dp[i][remaining_capacity]
                
            res = solve(i+1, remaining_capacity)  # Not take
            if remaining_capacity >= wt[i]:
                res = max(res, val[i] + solve(i+1, remaining_capacity - wt[i]))  # Take
            
            dp[i][remaining_capacity] = res
            return res
        
        return solve(0, W)


                
                
                

        