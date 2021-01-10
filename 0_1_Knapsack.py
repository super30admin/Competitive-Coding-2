# Created by Aashish Adhikari at 11:02 AM 1/9/2021

'''
Time Complexity:
O(2 ^ n) where n is the length of the weights array

Space Complexity:
O(2 ^n) since we are are creating new variables at each node of the recursion tree.

'''



def knapSack(W, wt, val, n):

    return helper(W, wt, val, [],[], 0, n)

def helper(W, weights, vals, current_set_weights, current_set_vals, pos, n):

    # base cases of recursion
    if sum(current_set_weights) == W:
        return current_set_vals
    if sum(current_set_weights) > W:
        l = len(current_set_vals)
        return current_set_vals[0: l-1]
    if pos == n-1:
        return current_set_vals



    # not take case
    case1 = helper(W, weights, vals, current_set_weights, current_set_vals, pos + 1, n)
    # take case
    current_set_weights.extend([weights[pos + 1]])
    current_set_vals.extend([vals[pos + 1]])
    case2 = helper(W, weights, vals, current_set_weights, current_set_vals, pos + 1, n)

    if sum(case1) > sum(case2):
        return case1
    else:
        return case2




#Driver Code
val = [6, 10, 12]
wt = [1, 2, 3]
W = 5
n = len(val)
print(knapSack(W, wt, val, n) )
