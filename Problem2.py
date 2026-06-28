'''
Brute force is to traverse a tree of the choice being choose or not choose 
a given item until the bag is full or items can no longer be fit.
Time complexity: O(2^n)
Space complexity: O(n)

We can use the dp to optimize the repeated subproblems.
Using the given items calculate the maximum profit with capacity k.
Start the k from 0 to W.
Keep adding items until the entire grid is filled in the dp.

Choosing an item (i) means we are choosing max profit from the items before i
and capacity of w - w[i]. Then we add i to get final capacity of w and maximum
profit by adding i.

Hence the formula:
dp[j] = max(prev[j], valMap[w] + prev[j-w])
Time complexity = O(W * n)
Space complexity = O(W)
'''
class Solution:
    def knapsack(self, W, val, wt):
        # code here
        valMap = {}
        for i in range(len(wt)):
            valMap[wt[i]] = val[i]
            
        prev = [0 for _ in range(W+1)]
        dp = [0 for _ in range(W+1)]
        sortedWeights = sorted(wt)
        
        for w in sortedWeights:
            for j in range(w, W+1):
                dp[j] = max(prev[j], valMap[w] + prev[j-w])
                
            prev = dp
            
        return dp[-1]