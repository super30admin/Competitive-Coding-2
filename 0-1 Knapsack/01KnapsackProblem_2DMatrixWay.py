class Solution:
    
    '''
    wt = [2,3,5],
    value = [6,2,1]
    '''
    
    def getMaxValue(self,wtList,valueList,maxCapacity):
        
        # 1. Create a 2D matrix 
        # rows = len(wtList)+1
        # cols = maxCapacity+1
        
        rows = len(wtList)+1
        cols = maxCapacity+1
        matrix = [[None for j in range(0,cols)] for i in range(0,rows)]
        
        # 0th row of the matrix will be 0
        for j in range(0,cols):
            matrix[0][j] = 0
        
        # 0th column in the matrix will be zero
        for i in range(0,rows):
            matrix[i][0] = 0
            
        
        # Fillup the matrix
        for i in range(1,rows):
            
            # Get the wt from wtList and valueList
            wt = wtList[i-1]
            value = valueList[i-1]
            # i =1, wt =2
            # i =2, wt =3
            # i =3, wt =5
            
            
            for j in range (1,cols):
                
                # If jth < wt, copy everything from above
                if j<wt:
                    matrix[i][j] = matrix[i-1][j]
                else:
                    # Get wt from above
                    above = matrix[i-1][j]
                    
                    # Get wt from (j-wt) places behind
                    behind = matrix[i-1][j-wt]
                    
                    # Set the max
                    matrix[i][j] = max(above,behind+value)
                    
        # Print the matrix 
        for i in range(0,rows):
            print(matrix[i])
        
        return matrix[rows-1][cols-1]
    
    def getSolution(self,valueList,wtList,maxCapacity):
        return self.getMaxValue(wtList, valueList, maxCapacity)

sol = Solution()

print(sol.getSolution([6,2,1],[2,3,5],8))
#print(sol.getSolution([2,5,3],[6,2,1],8))