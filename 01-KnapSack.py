"""
Runtime Complexity:
O(2^n) - the overall runtime complexity for this approach is exponential, because we check all the subarrays/subproblems to compute. The algorithm uses exhaustive search and therefore
we might endup with same subproblems computed again. The better approach would be to apply dp and maintain a table.
Space Complexity: O(1) -  because no new data structure was created to compute the solution.
Yes, the code worked.
The idea behind the algorithm is to check each subarrays and compute their weights and return the max of all. The subproblems goes on in recursive manner and some subproblems are repeated. We check whether the n'th element weight exceeds the capacity and if it does then we check on the elements left to it else we return a max with n included and exluded which will give out our global solution.
"""


def KnapSack(W,wt,val,n):
    if n ==0 or W ==0:
        return 0
    
    if wt[n-1]> W:
        return KnapSack(W,wt,val,n-1)
    
    else:
        return max(val[n-1]+ KnapSack(W-wt[n-1],wt,val,n-1), KnapSack(W,wt,val,n-1))
print("The maximum value that can be put into capacity W: ")
    


val = [60,100,20]
wt = [10,20,30]
W = 50
n = len(val)
print(KnapSack(W,wt,val,n))

"""
Dynamic Programming solution
Runtime Complextiy:
O(n^2) -  because we run two for loops to iterate through rows and columns
Space Complexity:
O(n) - because we create a list of capacity W.
"""
def KnapSack(W,wt,val,n):
    dp = [0 for i in range(W+1)]
    for i in range(1,n+1):
        for j in range(W,0,-1):
            if wt[i-1] <= j:
                dp[j]= max(dp[j], dp[j-wt[i-1]]+val[i-1])
    return dp[W]
print("The maximum value that can be put into container of capacity W:")
val = [60,100,120]
wt = [10,20,30]
W = 50
n = len(val)
print(KnapSack(W,wt,val,n))

