class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        
        if (m==0 or n==0):
            return 0
        
        mat = [[0 for i in range(n)] for j in range(m)]
        
        #print(mat)
        
        #last row
        for i in range(n):
            mat[m-1][i] = 1
            
        #last column
        for j in range(m):
            mat[j][n-1] = 1
        
        
        for i in range(m-2,-1,-1):
            
            for j in range(n-2,-1,-1):
                mat[i][j]=mat[i+1][j]+mat[i][j+1]
                #print(mat)
                
        print(mat)
        
        return mat[0][0]