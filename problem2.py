"""
Approach: simple case of choose/no choose. Bottom up approach used.
t.c. => O(n * W) where n = number of input items given
s.c. => O(n * W
"""

def main(W, val, wt):
    n = len(val)
    dp = [[0 for i in range(W + 1)] for j in range(n)]
    for i in range(n):
        for j in range(W + 1):
            if j == 0:
                dp[i][j] = 0
            elif i == 0:
                dp[i][j] = val[i] if j >= wt[i] else 0
            else:
                ret = 0
                if j >= wt[i]:
                    ret = (val[i] + dp[i - 1][j - wt[i]])
                dp[i][j] = max(ret, dp[i - 1][j])
    return dp[n - 1][W]

if __name__ == "__main__":
    val = [300, 200, 400, 500]
    wt = [2, 1, 5, 3]
    W = 10

    print(main(W, val, wt))
