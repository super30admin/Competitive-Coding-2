class Solution:
    
    def getMaxValue(self,wtList,valueList,maxCapacity,maxValue=0,index=0):
        
        # base
        
        if (index >= len(wtList)):
            return maxValue
        
        elif maxCapacity == 0:
            return maxValue
        
        elif (maxCapacity - wtList[index] < 0):
            return maxValue
        
        # logic
        
        # Case1: ignore wt
        case1 = self.getMaxValue(wtList, 
                                 valueList, 
                                 maxCapacity, 
                                 maxValue, 
                                 index+1)
        
        # Case2: pickup the wt
        case2 = self.getMaxValue(wtList, 
                                 valueList, 
                                 maxCapacity-wtList[index], 
                                 maxValue+valueList[index], 
                                 index+1)
        
        
        return max(case1,case2)
        
    def getSolution(self,valueList,wtList,maxCapacity):
        return self.getMaxValue(wtList, valueList, maxCapacity)

sol = Solution()
print(sol.getSolution([6,2,1],[2,3,5],8))