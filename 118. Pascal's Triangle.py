TC:O(N)
SC:O(1)
class Solution:
    
    def generate(self, numRows: int) -> List[List[int]]:
        if numRows==0:
            return 0
        m = numRows+1
        n = numRows+1
        list1 = []
        dp = [[0]*i for i in range(1,m)]
        print(dp)
        for i in range(m):
            for j in range(i+1):
                if i==0 :
                    dp[i][0]=1
                else:
                    dp[i-1][0]=1
                    dp[i-1][i-1]=1
        print(dp)
        for i in range(2,m-1):
            print("i",i)
            for j in range(i+1):
                if j>0 and j <i:
                    dp[i][j]=dp[i-1][j]+dp[i-1][j-1]        
                
        return dp