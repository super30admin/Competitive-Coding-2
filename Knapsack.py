# Time Complexity: O(n * w)
# Space Complexity: O(n * w)
class Solution:
    def knapsack(self, n, w, profit, weight) -> int:
        # N = 3
        # W = 6
        # profit = [10, 15, 40]
        # weight = [1, 2, 3]
        # ANS would be 65
        if n == 0 or w==0:
            return 0
        t = [[0 for i in range(w + 1)] for j in range(n + 1)]
        print("Default", t)
        for i in range(1, n + 1):
            for j in range(1, w+1):
                print(t)
                if weight[i-1] > j:
                    t[i][j] = t[i-1][j]
                else:
                    t[i][j] = max(t[i-1][j], profit[i-1] + t[i-1][j-weight[i-1]])
        print(t)
        return t[n][w]


s = Solution()

print(s.knapsack(3, 6, [10, 15, 40], [1, 2, 3]))
