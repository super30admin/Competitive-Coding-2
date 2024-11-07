# PROBLEM 2: 0/1 Knapsack Problem

""" Problem statement:
    Given N items where each item has some weight and profit associated with it 
    and also given a bag with capacity W, [i.e., the bag can hold at most W weight 
    in it]. The task is to put the items into the bag such that the sum of profits 
    associated with them is the maximum possible. 

    Note: The constraint here is we can either put an item completely into the bag 
    or cannot put it at all [It is not possible to put a part of an item into the 
    bag.
"""
# Solution:

def knapSack(capacity: int, val: list[int], wt: list[int])->int:
        # code here
        dp = [[0 for i in range(capacity + 1)] for i in range(len(wt) + 1)]
        #           num_columns                             num_rows
        # Approach: bottom-up DP
        # outer loop of items along with 0 for initial not choose case
        for i in range(len(wt) + 1):
            # inner loop of various capacities
            for j in range(capacity + 1):
                if i == 0:
                    dp[i][j] = 0
                # if the capacity is lower than current weight,
                # not choose case (value coming from row above)
                elif j < wt[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    # Choose max between not choose and     choose cases
                    #                       |                   |
                    dp[i][j] = max(dp[i-1][j], val[i-1] + dp[i-1][j - wt[i-1]])
        
        return dp[len(wt)][capacity]
        
def main():
    # Input: capacity = 5, val[] = [10, 40, 30, 50], wt[] = [5, 4, 6, 3] 
    capacity = 5
    val = [ 10, 40, 30, 50]   # (Please change inputs to verify)
    wts = [ 3, 4, 6, 3]
    output = knapSack(capacity, val, wts)
    print(f"The highest profit we can make is: {output}")

if __name__ == '__main__':
     main()
     # Output should be: 50


""" 
    Complexity Analysis:
Time: O(n * m) [n=number of items, m=capacity]
Space: O(n * m) [Space for the 2D dp array]
Did it run on GfG successfully: Yes, all test cases passed.
Did you face any issues: Yes, it took an hour to understand the pattern correctly, solve on paper and ultimately submit.

"""