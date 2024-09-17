"""
Learnings:
1. the # of rows in the dp array is 1 more than the len of weight array.
2. # of cols in the dp array is 1 more than the total capacity of the bag
3. if a cell in dp array -> dp[i][j], then corresponding item in weight and profit array is w[i-1] and p[i-1] because of (1.)
4. If capacity i.e j < w[i-1] (current elem weight): Don't choose
    else: we have a choice.
TC: o(N*M) N = len(weight)
M = capacity 
SC : O(N*M) 

othersie unoptimized recursion - O(2^n)
"""

def maxProfit(w, c, p):
    if c == 0:
        return 0
    dp = [[0 for x in range(0, c+1)] for x in range(0, len(w)+1)]
    for i in range(1, len(dp)):
        for j in range(1, len(dp[0])):
            if j < w[i-1]:
                # Not choosing
                dp[i][j] = dp[i-1][j]
            else:
                notChoosingCase = dp[i-1][j]
                choosingCase =  dp[i-1][j - w[i-1]] + p[i-1]
                dp[i][j] = max(notChoosingCase, choosingCase)
    return dp[-1][-1]
        
    
    
    
w = [4, 5, 1]
p = [1, 2, 3]
c = 4
print(maxProfit(w, c, p)) #3

p = [10, 20 ,30 ,40]
w = [30, 10, 20, 40]
c = 50
print(maxProfit(w, c, p)) #60

p = [60, 100, 120]
w = [10, 20, 30]
c = 50
print(maxProfit(w, c, p))  #220



