# Time Complexity : O(n*weight)
# Space Complexity :O(weight)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No

def knapSack(weight_needed, wt, val, n): 
    dp = [0 for i in range(weight_needed+1)] 
    for i in range(1, n+1): 
        for w in range(weight_needed, 0, -1): 
            if wt[i-1] <= w: 
                dp[w] = max(dp[w], dp[w-wt[i-1]]+val[i-1]) 
    return dp[weight_needed] 
  
  
if __name__ == '__main__': 
    profit = [20, 40, 60] 
    weight = [1, 2, 3] 
    weight_needed = 5
    n = len(profit) 
    print(knapSack(weight_needed, weight, profit, n)) 