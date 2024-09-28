
# Time Complexity: O(n * capacity)
# Space Complexity: O(n * capacity)
def findmax(w,val,capacity):
  if w is None or len(w)==0: return 0
  dp = [[0 for j in range(capacity+1)] for i in range(len(w)+1)]
  for i in range(1,len(w)+1):
    for j in range(capacity+1):
      
      if j<w[i-1]:
        dp[i][j]=dp[i-1][j]
      else:
        dp[i][j]=max(dp[i-1][j],val[i-1]+dp[i-1][j-w[i-1]])
  return dp[len(w)][capacity]
  
print(findmax([10,20,30],[200,10,50],50))
