# Submitted by : Aryan Singh_RN12MAY2023
# Time Complexity : O(maxWeight * number of weights)
# Space Complexity : O(maxWeight * number of weights)
# Did this code successfully run on Leetcode : NA
# Any problem you faced while coding this : Finding the second recursive method

class Solution:
    '''
    - max profit at each location found using dp
    - max of weight from up and profit + weight from diagonal back to 
    the number of weights above 
    '''
    def max_profit(self, num_items, max_weight, item_profits, item_weights):
        if num_items == 0 or max_weight == 0:
            return 0
        dp_table = [[0 for j in range(max_weight + 1)] for i in range(num_items + 1)]
        for r in range(1, num_items + 1):
            for c in range(1, max_weight + 1):
                if item_weights[r-1] > c:
                    dp_table[r][c] = dp_table[r-1][c]
                else:
                    dp_table[r][c] = max(dp_table[r-1][c], item_profits[r-1] + dp_table[r-1][c-item_weights[r-1]])
        return dp_table[num_items][max_weight]
    

# test method
def test_max_profit():
    s = Solution()
    num_items = 6
    max_weight = 10
    item_profits = [20, 5, 10, 40, 15, 25]
    item_weights = [1, 2, 3, 8, 7, 4]
    print(s.max_profit(num_items, max_weight, item_profits, item_weights))
    

test_max_profit()

