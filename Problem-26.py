# Time Complexity : O(mn) where m is the number of items and n is the value
# Space Complexity : O(mn) where m is the number of items and n is the value



class Knapsack:
    def solution1(self, weights, values, max_wt):
        dp_arr = [[0 for i in range(max_wt + 1)] for j in range(len(weights) + 1)]
        for i in range(1, len(dp_arr)):
            for j in range(1, len(dp_arr[0])):
                if j > weights[i - 1]:
                    dp_arr[i][j] = max(values[i - 1] + dp_arr[i][j - weights[i - 1]], dp_arr[i - 1][j])
                else:
                    dp_arr[i][j] = dp_arr[i - 1][j]
        return dp_arr[-1][-1]
