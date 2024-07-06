Time complexity - O(amount * no of weights)
space complexity - O(amount * no of weights)
Ran on Leetcode - Not present in leetcode but code is running successfully.
Problems faced - None

Code Description :
we are given finite number of weights and their values we have fill a knapsack such that we get the maximum value out of the weights stored in knapsack.As we have common sub-problems we go with dynamic programming.The logic used is we either pick the item ot not pick the item.
we use this logic to fill a 2D array.The last cell gives us the required output.


value=[60,100,120]
weight=[10,20,30]
capacity=50
out=[[None for i in range(capacity+1)]for j in range(len(weight)+1)]

for i in range(len(weight)+1):
    for j in range(capacity+1):
        if i==0:
            out[i][j]=0
        elif j<weight[i-1]:
            out[i][j]=out[i-1][j]
        else:
            out[i][j]=max(out[i-1][j],value[i-1]+out[i-1][j-weight[i-1]])
print out[len(weight)][capacity]