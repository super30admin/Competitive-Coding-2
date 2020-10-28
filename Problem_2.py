"""
Time Complexity : O(m*n) where m is size of weight array and n is maximum capacity
Space Complexity : O(m*n) as it is a 2D array
Did this code successfully run on Leetcode : Not o leetcode
Any problem you faced while coding this : No


Your code here along with comments explaining your approach:
This problem is somewhat similar to coin problem where we have the choice of either choosing the weight
or not. We can draw the decision tree and see for ourselves the repeated subproblems. The 2D matrix will
be built in the same way.
"""


def knapSack(W, wt, profit, n):
    K = [[0 for x in range(W + 1)] for x in range(n + 1)]
    for i in range(n + 1):
        for w in range(W + 1):
            if i == 0 or w == 0:
                K[i][w] = 0
            elif wt[i-1] > w:
                K[i][w] = K[i-1][w]
            else:
                K[i][w] = max(profit[i-1] + K[i-1][w-wt[i-1]],  K[i-1][w])

    return K[n][W]
