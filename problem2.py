#time- O(2**n) at every step we have two options
#space- O(1) using recursion stack
class Solution:
    def knapSack(self,W, wt, val,n):
        Rem_Cap=W
        return self.Helper(Rem_Cap, wt, val, 0,0)

    def Helper(self,Rem_Cap, wt, val, i,max_profit):
        #base case
        if i>=n or Rem_Cap==0:
            return max_profit
        if wt[i]>Rem_Cap:
            return self.Helper(Rem_Cap, wt, val, i+1,max_profit)
            
        return max(self.Helper(Rem_Cap-wt[i], wt, val, i+1,max_profit+val[i]),self.Helper(Rem_Cap, wt, val, i+1,max_profit))

# Driver code
val = [60, 100, 120]
wt = [10, 20, 30]
W = 50
n = len(val)
s=Solution()
print(s.knapSack(W, wt, val, n))
