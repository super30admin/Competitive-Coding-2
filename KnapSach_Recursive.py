class Solution:
    def knapSack(self, W, wt, val, n):
        def helper(wt, val, W, idx, n, max_profit):
            if W <= 0 or idx >= len(wt) or n <= 0:
                return max_profit

            if wt[idx] > W:
                return helper(wt, val, W, idx + 1, n, max_profit)
            case1 = helper(wt, val, W - wt[idx], idx + 1, n - 1, max_profit + val[idx])
            case0 = helper(wt, val, W, idx + 1, n, max_profit)
            return max(case1, case0)
        return helper(wt, val, W, 0, n, 0)


if __name__ == '__main__':
    n = 3
    W = 50
    wt = [10, 20, 30]
    val = [60, 100, 120]
    obj = Solution()
    print(obj.knapSack(W, wt, val, n))
