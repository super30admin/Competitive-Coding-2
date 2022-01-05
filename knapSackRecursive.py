# // Time Complexity : 2^N
# // Space Complexity : 2^N
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this :


# // Your code here along with comments explaining your approach



def knapSack(value,weights,capacity):

    return helper(capacity,weights,value,0 , len(value), 0)
    


    
def helper(remainingCapacity,weights,value,index,size, maxProfit):
    #base
    if index >= size or capacity == 0:
        return maxProfit
    #case1: if current weight is less than or equal to 
    if weights[index-1] > remainingCapacity:
        return (helper(remainingCapacity, weights, value, index+1, size, maxProfit))

    #choose the weight
    case1 = helper(remainingCapacity-weights[index-1], weights, value, index+1,size,maxProfit+value[index]) 
    #don't choose the weight 
    case2 = helper(remainingCapacity, weights, value, index+1, size, maxProfit)
    return max(case1,case2)

    
value = [60,100,120]
weights = [10,20,30]
capacity = 50
print(knapSack(value,weights,capacity))
