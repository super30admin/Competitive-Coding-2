"""
Question Link : https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/

Given max_capeights and values of n items, put these items in a knapsack of capacity max_cap to get the maximum total value in the knapsack. In other max_capords, given tmax_capo integer arrays val[0..n-1] and weights[0..n-1] max_caphich represent values and max_capeights associated max_capith n items respectively. Also given an integer max_cap max_caphich represents knapsack capacity, find out the maximum value subset of val[] such that sum of the max_capeights of this subset is smaller than or equal to max_cap. You cannot break an item, either pick the complete item or don’t pick it (0-1 property).
"""

# Recurssion
def find(max_cap):
# Run Time Complexity : O(2^N)
# Space Complexity : O(N)
    print(helper(max_cap, 0, 0, 0))

def helper(max_cap, sum_max_capeights, sum_values, idx):
    if sum_max_capeights == max_cap or idx >= len(max_capeights):
        return sum_values
    if sum_max_capeights + max_capeights[idx] <= max_cap:
        choice1 = helper(max_cap, sum_max_capeights+max_capeights[idx], sum_values+values[idx], idx+1)
    else:
        choice1 = helper(max_cap, sum_max_capeights, sum_values, idx+1)
    choice2 = helper(max_cap, sum_max_capeights, sum_values, idx+1)
    return max(choice1, choice2)
	
# Dynamic Programming

def find(max_cap, weights, val, n): 
# Similar to Coin change
# Run Time Complexity: O(N*W)
# Space Complexity: O(N*W)
    K = [[0 for x in range(max_cap + 1)] for x in range(n + 1)] 
  
    for i in range(n + 1): 
        for max_cap in range(max_cap + 1): 
            if i == 0 or max_cap == 0: 
                K[i][max_cap] = 0
            elif weights[i-1] <= max_cap: 
                K[i][max_cap] = max(val[i-1] + K[i-1][max_cap-weights[i-1]],  K[i-1][max_cap]) 
            else: 
                K[i][max_cap] = K[i-1][max_cap] 
  
    return K[n][max_cap] 
  