# Time Complexity:-(O(i*w)), i=len(values), w=weightmax
# Space Complexity:- O(i*w), i=len(values), w=weightmax
# Approach:- At every step we have a choice we can either take an item(provided the weight of the item doesn't exceed weightmax) or not include it.
# The algorithm is the exploration of all the possible choices and finding the maxvalue that we can get while exploring the possible choices.
import sys
from functools import lru_cache
def zero_one_knapsack(weights,values,weightmax):
    @lru_cache(maxsize=None)
    def knapsack_recurse(i,weight):
        if i==len(weights):
            return 0
        taken=-sys.maxsize
        #pick an item provided the weight of the item doesn't exceed the maxweight
        if weight+weights[i]<=weightmax:
            taken=values[i]+knapsack_recurse(i+1,weight+weights[i])
        # return the max value that we can get by choosing or not choosing an item
        return max(taken,knapsack_recurse(i+1,weight))
    return knapsack_recurse(0,0)

print(zero_one_knapsack([10,20,30],[60,100,120],50))

