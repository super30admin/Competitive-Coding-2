

def PA(profit_array, weights_array, max_capacity):
    
    memo = {}
    def helper(index, capacity): 
        # Fill the base case later
        
        if index >= len(profit_array) or capacity <=0: 
            return 0
            
        if (index, capacity) in memo: 
            return memo[(index, capacity)]
            
        not_choosing = helper(index+1, capacity)
        choosing = 0
        if weights_array[index] <= capacity: 
            choosing = profit_array[index] + helper(index+1, capacity - weights_array[index])

        # print(index, not_choosing, choosing, capacity)
        
        memo[(index, capacity)] = max(not_choosing, choosing)
        
        return memo[(index, capacity)]
    
    return helper(0, max_capacity)
    
    
print(PA([15,20,30], [1,3,4], 4))
        
    
