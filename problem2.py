'''
KNAPSACK PROBLEM
TIME COMPLEXITY: O(w*n) , n=capacity/10
SPACE COMPLEXITY:  O(w*n) , n=capacity/10
LEETCODE: Yes
DIFFICULTIES: Yes, but could resolve it
'''

w = [10, 20, 30]  # weights
v = [100, 1000, 20]  # values
c = 50  # total capacity

row = len(w) + 1  # row count is no of weights
col = (c // 10) + 1  # column count is capacity distribution

# dp matrix
# an extra row and column, and it will be set 0
m = [[0 for i in range(col)] for j in range(row)]


for i in range(1, row):
    for j in range(1, col):
        rw = j * 10 - w[i-1]  # remaining weight
        if rw < 0:
            m[i][j] = m[i-1][j] # value of previous weight i.e., previous row weight
        else:
            # I chose the weight
            case1 = v[i-1] + m[i-1][rw // 10] # value + previous max weight

            # I didn't choose the weight
            case2 = m[i - 1][j] # previous max weight

            m[i][j] = max(case1, case2)
print(m)
print(m[row - 1][col - 1])

