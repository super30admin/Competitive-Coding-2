class Solution:

    def knapsack(self, w, val, c, maxProfit, i):

        # if ((c - w[i]) < 0) or (c > w[i]) or (i == len(w)) or (c == 0):
        #     return maxProfit

        if i == len(w):
            return maxProfit
        
        if c - w[i] < 0:
            return maxProfit
    
        # zero case
        case1 = self.knapsack(w, val, c, maxProfit, i + 1)
            
        # one case
        case2 = self.knapsack(w, val, c - w[i], maxProfit + val[i], i + 1)

        return max(case1, case2)

w = [2, 3, 5]
val = [1, 2, 6]
c = 8
obj1 = Solution()
print(obj1.knapsack(w, val, c, 0, 0))
            
