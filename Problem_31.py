# Exhaustive Approach: Knapsack problem

def helper(wt, P, C, idx):
    n = len(wt)
    if C == 0 or idx < 0:
	    return 0
    
    #choose
    c1 = P[idx] + helper(wt, P, C-wt[idx], idx-1)
    
    #dnt choose
    c2 = helper(wt, P, C, idx-1)
    
    print(c1, c2)
    return max(c1, c2)
    
def knapSack(C, wt, P):
    return helper(wt, P, C, len(wt) - 1)


# Driver Code
if __name__ == '__main__':
	profit = [10, 15, 40]
	weight = [1, 2, 3]
	C = 50
	n = len(profit)
	print(knapSack(C, weight, profit))
