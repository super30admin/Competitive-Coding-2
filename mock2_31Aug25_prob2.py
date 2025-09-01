'''
KnapSack Problem 
'''
'''
Solution 1: Recursion
Choose/No choose. At each iteration, we either don't choose the item or we choose
the item. If we do choose, we first check if by choosing this item we go beyond
the capacity, if not we choose the item.
Time Complexity: O(2^N), N = totat items given/len(values array)
Space Complexity: O(1), if we count the space of only auxilary variables and not the system stack 
'''
class Solution:
    def findMaxValThatCanBeStored(self,values, weights,capacity):
        self.weights = weights
        max_val = self.helper(values,capacity,0)
        return max_val
    
    def helper(self,values,remaining_capacity,idx):
        # base
        if idx==len(values):
            return 0

        # logic
        # no choose
        case1 = self.helper(values,remaining_capacity,idx+1)

        # choose
        case2 = 0
        if remaining_capacity-self.weights[idx]>=0:
            case2 = values[idx] + self.helper(values, remaining_capacity-self.weights[idx],idx+1)

        return max(case1,case2)    

'''
Solution 2: Recursion + Memoization
Choose/No choose. At each iteration, we either don't choose the item or we choose
the item. If we do choose, we first check if by choosing this item we go beyond
the capacity, if not we choose the item.
Time Complexity: O(NxCapacity), N = totat items given/len(values array)
Space Complexity: O(NxCapacity), if we count the space of only auxilary variables and not the system stack 
'''
class Solution:
    def findMaxValThatCanBeStored(self,values, weights,capacity):
        self.weights = weights
        self.mem = {}
        max_val = self.helper(values,capacity,0)
        return max_val
    
    def helper(self,values,remaining_capacity,idx):
        # base
        if idx==len(values):
            return 0    
        
        if (idx,remaining_capacity) in self.mem:
            return self.mem[(idx,remaining_capacity)]

        # logic
        # no choose
        case1 = self.helper(values,remaining_capacity,idx+1)

        # choose
        case2 = 0
        if remaining_capacity-self.weights[idx]>=0:
            case2 = values[idx] + self.helper(values, remaining_capacity-self.weights[idx],idx+1)
        
        self.mem[(idx,remaining_capacity)] = max(case1,case2) # memoization
        
        return max(case1,case2)   


    
    


mySol = Solution()
print("First : ", mySol.findMaxValThatCanBeStored([1,2,2,3],[5,2,2,3],4)) # 4
print("Second : ", mySol.findMaxValThatCanBeStored([1,2,3],[4,5,1],4)) # 3
print("Third : ", mySol.findMaxValThatCanBeStored([1],[4],4)) # 1
print("Fourth : ", mySol.findMaxValThatCanBeStored([1],[6],4)) # 0

