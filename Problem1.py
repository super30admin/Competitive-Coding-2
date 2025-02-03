# Time Complexity : O(n * capacity)
# Space Complexity : O(n * capacity)
# Did this code successfully run on Leetcode : YES

# Any problem you faced while coding this : YES

# Initially, I used a tuple as the key for the memo object which passed only 1011/1116 test cases with a memory limit exceeded error
# When I switched it to a 2D hashmap, it worked because it uses memory more compactly. When using a tuple, although it avoids collisions,
# it creates a new entry for every new pair of values (ix, rem_capacity) and for large inputs, it easily exceeds the memory allocated to the program 

# Another point I learnt was that for this problem it is more efficient to walk backwords from the end of the array during recursion rather than forwards


# Your code here along with comments explaining your approach

class Solution:
    # Function to return max value that can be put in knapsack of capacity.

    def knapSack(self, capacity, val, wt):
        memo = {}
        # code here
        def search(ix, rem_capacity):
            if ix in memo:
                if rem_capacity in memo[ix]:
                    return memo[ix][rem_capacity]
                    
            # base case
            if ix < 0 or rem_capacity == 0:
                return 0
            
            # logic
            if wt[ix] > rem_capacity:
                choose = float('-inf')
                _choose = search(ix - 1, rem_capacity)
            else:
                choose = search(ix-1, rem_capacity - wt[ix]) + val[ix]
                _choose = search(ix - 1, rem_capacity)
                
            if ix in memo:
                memo[ix][rem_capacity] = max(choose, _choose)
            else:
                memo[ix] = {}
                memo[ix][rem_capacity] = max(choose, _choose)
            
            return memo[ix][rem_capacity]
        
        return search(len(val)-1, capacity)