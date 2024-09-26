class Solution:
    def Knapsack(self, weights, values, maxWeight):
        arr=[[0 for _ in range(0, maxWeight+1)] for _ in range(len(weights)+1)]
        for i in range(1, len(weights)+1):
            for j in range(0, maxWeight+1):
                if weights[i-1]>j:
                    arr[i][j]=arr[i-1][j]
                else:
                    arr[i][j]=max(arr[i-1][j], arr[i-1][j-weights[i-1]]+values[i-1])
        return arr[len(weights)][maxWeight]


    #     return self.helper(weights, values, maxWeight, 0, 0)
    
    # def helper(self, weights, values, maxWeight, index, TotalValue):
    #     if index > len(weights)-1 or maxWeight==0:
    #         return TotalValue
    #     if weights[index]>maxWeight:
    #         return self.helper(weights, values, maxWeight, index+1, TotalValue)
    #     case1 = self.helper(weights, values, maxWeight-weights[index], index+1, TotalValue+values[index])
    #     case2 = self.helper(weights, values, maxWeight, index+1, TotalValue)
    #     return max(case1, case2)
        


sol = Solution()
print(sol.Knapsack([10,10,20,30,35] , [60,60,100,120,100], 50))

""" Time complexity - O(mn) where m is the number of weights and n is the maxcapacity given
Space Complexity - O(mn) """

