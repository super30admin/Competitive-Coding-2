'''
Time Complexity :O(n)
Space Complexity: O(n)
Explanation:
Start from the back, there are 2 paths to choose a weight, either to take the weight and subtract it to the total sum or
not take the weight itself and move to next element.
Check if the wt itself is greater than the target weight if yes then move to next element.
Check if depth is reached or the weight subtracted is 0 then return 0

Use memoization to keep track of subproblem totals in dictionary to help reduce time complexity. At each level we save
the (depth, value) = max(subproblems)
'''
dict1 = {}
def knapSack(W, wt, val, n):

    if n == 0 or W == 0 :
        return 0
    if (wt[n-1] > W):
        return knapSack(W, wt, val, n-1)

    else:
        if (n,val[n-1]) in dict1.keys():
            return dict1[(n,val[n-1])]
        else:
            dict1[(n,val[n-1])] = max(val[n-1] + knapSack(W-wt[n-1], wt, val, n-1), knapSack(W, wt, val, n-1))
            return dict1[(n,val[n-1])]


val = [60, 100, 120]
wt = [10, 20, 30]
W = 50
n = len(wt)
print knapSack(W, wt, val, n)

