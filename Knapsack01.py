class Knapsack01(object):
    '''
    Solution:
    1. Problem can be solved using recursion and has overlapping subproblems and so use dynamic programming. Recursive
        step would be based on whether the weight is chosen or not.
    2. If weight is not chosen, the value of the cell would be previous row's extract, otherwise it would be maximum of
        [previous row (same column) value, value + value at -- column minus value (previous row)]
    3. Return the last cell's value

    --- Problem not found on Leetcode but almost similar to coin change on leetcode
    Time Complexity : O(maxWeight * number of weights)
    Space Complexity: O(maxWeight * number of weights)
    '''

    def knapsack(self, maxW, weights, values):

        if (weights == None or len(weights) == 0):
            return 0

        knapsack = [[0 for i in range(maxW + 1)] for j in range(len(weights) + 1)]

        for wtRow in range(1, len(weights) + 1):
            for maxWtCol in range(1, maxW + 1):
                if (maxWtCol < weights[wtRow - 1]):
                    knapsack[wtRow][maxWtCol] = knapsack[wtRow - 1][maxWtCol]
                else:
                    knapsack[wtRow][maxWtCol] = max(values[wtRow - 1] + knapsack[wtRow - 1][maxWtCol - (weights[wtRow-  1])],
                                                            knapsack[wtRow - 1][maxWtCol])

        return knapsack[len(weights)][maxW]

val = [60, 100, 120]
wt = [1, 2, 3]
W = 5
obj = Knapsack01()
print(obj.knapsack(W, wt, val))