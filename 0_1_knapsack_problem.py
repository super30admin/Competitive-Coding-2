from typing import List


class Solution:

    def knapsack_0_1_problem(self, weights: List[int], values: List[int], capacity: int) -> int:
        """
            // Time Complexity : O(mn)
                        'm' is the no.of items and 'n' is the capacity
            // Space Complexity : O(mn)
            // Did this code successfully run on Leetcode : N/A
            // Any problem you faced while coding this : No
            // Three line explanation of solution in plain english :
                    - For a given a capacity, we make a choice
                      to choose the the current item or don't choose
                      the current item
                    - Each sub problems has the optimal answer to the question,
                      if I have the given items with their weights and values and
                      a capacity what is the maximum value I can acheive.
                    - The final sub problem has the answer to the overall solution
                      for a given list of items and the knapsack capacity.
        """

        # edge case
        if not weights or not values or capacity <= 0:
            return 0

        # not required but to avoid confusion with indexes
        weights.insert(0, 0)
        values.insert(0, 0)

        items = len(weights)
        dp = [[None for cap in range(capacity + 1)] for item in range(items)]

        # No item - Max value 0
        for cap in range(capacity + 1):
            dp[0][cap] = 0
        # No cap - Max value 0
        for item in range(items):
            dp[item][0] = 0

        for item in range(1, items):
            for cap in range(1, capacity + 1):
                # if the current bag capacity cannot hold the current item
                # choose the max we could get not choosing the current item
                # with the same capacity
                if cap - weights[item] < 0:
                    dp[item][cap] = dp[item - 1][cap]
                else:
                    # for each item I have two options
                    #                                   choose the item                 don't choose the item
                    dp[item][cap] = max(values[item] + dp[item - 1][cap - weights[item]], dp[item - 1][cap])
        return dp[item][cap]

    def knapsack_0_1_problem_brute_force(self, weights: List[int], values: List[int], capacity: int):
        """
            // Time Complexity : O(2^n) For each item we have two choices
            // Space Complexity : If recursion space is considered, O(m+n) 'm' is the capacity, 'n' is the least weight
            // Any problem you faced while coding this :
                        Missed an the case when ## cap - weights[item] < 0 ##
                        and we need to skip the item
        """
        # edge case
        if not weights or not values or capacity <= 0:
            return 0

        return self._helper(weights, values, capacity, 0, 0)

    def _helper(self, weights: List[int], values: List[int], capacity: int, item: int, sum: int):
        # base case
        if item >= len(weights) or capacity == 0:
            return sum
        # if the weight of the current item is more than
        # the bag capacity, then we cannot choose the current item
        # we move with the next item
        if weights[item] > capacity:
            return self._helper(weights, values, capacity, item + 1, sum)
        else:
            # logic
            # case 1 - choose the item
            case_1 = self._helper(weights, values, capacity - weights[item], item + 1, sum + values[item])
            # case 2 - don't choose the item
            case_2 = self._helper(weights, values, capacity, item + 1, sum)
            return max(case_1, case_2)


if __name__ == '__main__':
    h = Solution()
    weights = [1, 2, 3]
    values = [60, 100, 120]
    print(h.knapsack_0_1_problem_brute_force(weights, values, 5))
    print(h.knapsack_0_1_problem(weights, values, 5))
    weights = [5, 3, 4, 2]
    values = [60, 50, 70, 30]
    print(h.knapsack_0_1_problem_brute_force(weights, values, 5))
    print(h.knapsack_0_1_problem(weights, values, 5))
    weights = [10, 20, 30]
    values = [2, 1, 10]
    print(h.knapsack_0_1_problem_brute_force(weights, values, 30))
    print(h.knapsack_0_1_problem(weights, values, 30))
    print(h.knapsack_0_1_problem(weights, values, -10))
    print(h.knapsack_0_1_problem(weights, values, 0))
    print(h.knapsack_0_1_problem_brute_force(weights, values, -10))
    print(h.knapsack_0_1_problem_brute_force(weights, values, 0))
