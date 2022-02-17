# Time Complexity : O(n*W)
# Space Complexity : O(n*W)
# Did this code successfully run on Leetcode : N/A
# Any problem you faced while coding this : No

class Solution:
    def knapsack(self,w,v,W):
        rows, cols = (W+1, len(v))
        self.knapsackArray = [[None for i in range(cols)] for j in range(rows)]
        return self.knapsackSolution(w,v,W,0)
    
    def knapsackSolution(self,w,v,W,index):
            if index == len(w) or W == 0:
                return 0
            
            if w[index] > W:
                return 0

            if self.knapsackArray[W][index] is not None:
                return self.knapsackArray[W][index]
            
            #select element
            selectAns = v[index] + self.knapsackSolution(w,v,W-w[index],index+1)
            #notSelecting element
            notSelectAns = self.knapsackSolution(w,v,W,index+1)
            
            self.knapsackArray[W][index] = max(selectAns,notSelectAns)
            
            return self.knapsackArray[W][index]

obj1 = Solution()
values = [60,100,120]
weights = [10,20,30]
capacity =50
print(obj1.knapsack(weights,values,capacity))