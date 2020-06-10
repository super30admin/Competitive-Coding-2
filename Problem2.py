"""

    Student : Shahreen Shahjahan Psyche
    Time Complexity : O(W*N)
    Space Complexity : O(W*N)

"""

class Solution:

    def knapsack_dp(self, W, wt, val): 

        # edge case
        if W == 0 or not wt or not val:
            return 0
        

        size = len(val)

        # creating the matrix which will hold the result of my sub-problems
        records = [[0 for x in range(W + 1)] for x in range(size + 1)] 

        for i in range(size + 1): 
            for w in range(W + 1):
                # if either of my capacity or weight is 0, then I am filling that 
                # row or col with 0's
                if i == 0 or w == 0: 
                    records [i][w] = 0
                # here, if the current capacity is greater than my current items weight
                # then I am checking whether adding this item maximizes my value
                elif wt[i-1] <= w: 
                    records[i][w] = max(val[i-1]  + records[i-1][w-wt[i-1]],  records[i-1][w]) 
                # if adding the current item exceeds the capacity, then I am going with the 
                # zero case where I am not taking the item.
                else: 
                    records[i][w] = records[i-1][w] 
    
        return records[size][W] 


# Test-case
knapsack = Solution()
W = 50
value = [60, 100, 120]
weight = [10, 20, 30]

print("Maximum value can be ", knapsack.knapsack_dp(W, weight, value))