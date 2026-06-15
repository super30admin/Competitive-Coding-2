#https://www.geeksforgeeks.org/dsa/0-1-knapsack-problem-dp-10/
# Time Complexity  : O(W), where W is the capacity of the knapsack. We traverse the dp array of size W once for each item.
# Space Complexity : O(W), as we use a 1D array of size W+1

# Problems Faced   : None
def knapsack(W, val, wt):
    i = len(wt)                                        # total number of items
    dp = [0] * (W + 1)                                 # 1D array of size W+1, initialized to 0

    for row in range(1, i + 1):                        # loop through each item
        for j in range(W, wt[row - 1] - 1, -1):       # traverse capacity right to left, stop at item's weight

            pick = dp[j - wt[row-1]] + val[row-1]     # pick current item: add its value + best with remaining capacity
            notPick = dp[j]                            # skip current item: keep existing best value

            dp[j] = max(pick, notPick)                 # store the better choice

    return dp[W]                                       # answer: max value at full capacity

if __name__ == "__main__":
    val = [1, 2, 3]                                    # values of items
    wt = [4, 5, 1]                                     # weights of items
    W = 4                                              # max capacity of knapsack
    print(knapsack(W, val, wt))                        # output: 3