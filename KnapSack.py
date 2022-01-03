# Time Complexity : O(Capacity * W) where W is size of weight elements
# Space Complexity : O(Capacity * W) where W is size of weight elements
# Did this code successfully run on Leetcode : N/A
# Three line explanation of solution in plain english
'''The DP formula chooses the maximum between the value gained without the current weight being added and the value after the current being added.'''
# Your code here along with comments explaining your approach

value = [60, 100, 120]
weight = [10, 20, 30]
capacity = 50

dp = [[0] * (capacity + 1) for _ in range(len(weight))]
for i in range(len(dp)):
  for j in range(weight[i], len(dp[0])):
    if i == 0:
        dp[i][j] = value[i]
    else:
        dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i])
print(dp[-1][-1])

# Time Complexity : O(Capacity * W) where W is size of weight elements
# Space Complexity : O(Capacity)
# Did this code successfully run on Leetcode : N/A
# Three line explanation of solution in plain english
'''Same approach as above but uses only two lists. Reduces space complexity.'''
# Your code here along with comments explaining your approach

value = [60, 100, 120]
weight = [10, 20, 30]
capacity = 50

prev = [0] * (capacity + 1)
temp = [0] * (capacity + 1)
for i in range(len(dp)):
  for j in range(weight[i], len(dp[0])):
    if i == 0:
        prev[j] = value[i]
    else:
        temp[j] = max(prev[j], prev[j - weight[i]] + value[i])
        prev = temp[:]
print(dp[-1][-1])

