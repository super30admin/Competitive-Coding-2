# 2^m where m - array of weights
# Space - o(n) - recursive stack space
#Input:  W = 4, profit[] = [1, 2, 3], weight[] = [4, 5, 1]

def knapsackRec(W,  val, wt, n):
    
    if W==0 or n==0:
        return 0
    
    choose = 0 
    if wt[n-1]<=W:
        choose = val[n-1] + knapsackRec(W-wt[n-1],val,wt,n-1)
        
    
    not_choose = knapsackRec(W,val,wt,n-1)
    
    return max(choose,not_choose)

print(knapsackRec(4,[1, 2, 3],[4, 5, 1],3))



    