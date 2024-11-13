#Knapsack with dp : t:O(m*n),s:O(m*n)
class Solution:
    def knapSack(self, capacity:int, val:list[int], wt:list[int])-> int:

        m = len(val)
        n = capacity
        
        # dp array
        dp = [[0]*(n+1) for i in range(m+1)] #init dp
        # // base case
        #not needed since all rows are 0
        # // logic
        for i in range(1,m+1):              
            for j in range(1,n+1):
                if j < wt[i-1]:                                                 # if current capacity less than weight of item // i-1 since (1,m+1),(1,n+1)                        
                    dp[i][j] = dp[i-1][j]                                       # no choose case
                else:
                    dp[i][j]  = max(dp[i-1][j], val[i-1]+dp[i-1][j-wt[i-1]])    # choose case // j-wt[i] -> current capacity - weight[current]

        return dp[m][n]
    
print(Solution().knapSack(capacity = 4,val = [1, 2, 3,],wt =[4,5,1])) #op = 3

# recursive helper: t:O(2^n) for recursion and O(n) for stack space
# class Solution:
#     def knapSack(self, capacity, val, wt):
#             # code here
#         return self.helper(capacity,wt,val,0,0)
        
#     def helper(self,capacity,wt,val,i,totalProfit):
#         if i >=len(wt):                       #if index goes beyond lenght of weight array return final profit
#             return totalProfit
            
#         case0 = self.helper(capacity,wt,val,i+1,totalProfit)
            
#         case1 = 0
#         if wt[i] <=capacity:                  # if item can fit in given capcity
#             case1 = self.helper(capacity-wt[i],wt,val,i+1,totalProfit+val[i])
            
#         return max(case0,case1)