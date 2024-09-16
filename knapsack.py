# solution 1 recusion method with time complexity O(2^n) because choose or not choose and space comleixty O(1)
class Solution(object):
    def knapsack(self, weights, profits, capacity,n):
        # null case
        if weights == None or profits == None or n == None or capacity == None or not weights or not profits or n == 0 or capacity == 0: 
            return 0
        # if weight of the item is greater than the capacity
        elif weights[n - 1] > capacity:
            # skip because not optimal
            return self.knapsack(weights, profits, capacity, n-1)
        # in else case send the most optimiszed solution
        else:
            return max(self.knapsack(weights, profits, capacity, n-1), profits[n-1] + self.knapsack(weights, profits, capacity-weights[n-1], n-1))
            
# tabular (table) approch
# with O(m x n) time complexity and same space complexity
# still needed to use debugger because of lots of comparision
    def knapsack2(self, weights, profits, capacity, n):
        # null case
        if weights == None or profits == None or n == None or capacity == None or not weights or not profits or not n or not capacity:
            return 0
        # creating the colums capacity wise and rows according to the n items
        table = [[0 for i in range(capacity+1)] for i in range(n+1)]
        # ato void index out of bound (-1) types of error we added +1
        for item in range(n + 1):
            for weight in range(capacity + 1):
                if item == 0 or weight == 0:
                    table[item][weight] = 0
                elif weights[item - 1] <= weight:
                    table[item][weight] = max(profits[item-1] + table[item-1][weight-weights[item -1]], table[item-1][weight])
                else: 
                    table[item][weight] = table[item-1][weight]
        return table[item][weight]
            

sol = Solution()
capacity= 6
weights = [1,2,3]
profits=[10,15,40]
n = len(weights)
print(sol.knapsack(weights, profits, capacity, n))
print(sol.knapsack2(weights, profits, capacity, n))
