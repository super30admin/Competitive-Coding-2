class Solution:
    
    '''
    wt = [2,3,5],
    value = [6,2,1]
    '''
    
    def getMaxValue(self,wtList,valueList,maxCapacity):
        
        # Create 2 lists and fill everything with 0
        previousList = [0]*(maxCapacity+1)
        currentList = [0]*(maxCapacity+1)
        
        # Iterate the matrix list
        for index in range(0,len(wtList)):
            
            # Get the wt and value
            wt = wtList[index]
            val = valueList[index]
            
            # Iterate the matrix list
            for i in range(0,len(currentList)):
                
                if i < wt:
                    continue
                
                else:
                    above = previousList[i]
                    behind = previousList[i-wt]
                    currentList[i] = max(above,behind+val)
            
            # print('Matix list for wt:\t'+str(wt)+'\t is:\t',currentList)
            
            # Copy currentList to previousList
            previousList = currentList[0:]
        
        return currentList[-1]
            
    def getSolution(self,valueList,wtList,maxCapacity):
        return self.getMaxValue(wtList, valueList, maxCapacity)

sol = Solution()

print(sol.getSolution([6,2,1],[2,3,5],8))
#print(sol.getSolution([2,5,3],[6,2,1],8))