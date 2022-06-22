def knapSack(cap, wt, val, n): 
    # Base Case
    # n is number of items we can take and C is capacity
    if n == 0 or cap == 0: return 0
 
    # If weight of the nth item is more than Knapsack of capacity C,
    # then this item cannot be included in the optimal solution
    if (wt[n-1] > cap): return knapSack(cap, wt, val, n-1)
    else:
        # return the maximum of two cases: 
        # n'th item included
        # not included
        return max(val[n-1] + knapSack(cap-wt[n-1], wt, val, n-1), # if we include the item, then we reduce C by wt[i-1], and reduce n by 1
            knapSack(cap, wt, val, n-1))  # if we skip the item, we don't change capacity, just reduce the n by 1 

#Driver Code
val = [10,15,40]
wt = [1,2,3]
W = 6
n = len(val)
print(knapSack(W, wt, val, n))

"""
 Competitive-Coding-2 on  master [+] via 🐍 v3.9.12 
❯ python3 01knapsack_recusive.py
65



TC O(2^n).  As there are redundant subproblems.

SC Auxiliary Space :O(1) + O(N). 
As no extra data structure has been used for storing values but O(N) auxiliary stack space(ASS) has been used for recursion stack.

"""