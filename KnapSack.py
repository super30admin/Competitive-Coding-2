mem = {}

# Time complexity is O(N*W), where N is the number of values and W is the capacity
# Space complexity is also O(N*W)
def helper(values,weights,capacity,index,currVal):
    # Base Case
    if(index == len(weights) or capacity == 0):
        return currVal
    if((capacity,index) in mem):
        return mem[(capacity,index)]
    case1 = 0
    # Select the weight at Index
    if(weights[index] <= capacity):
        case1  = helper(values,weights,capacity-weights[index],index+1,currVal+values[index])
    # Not selecting the weight at the index
    case2 = helper(values,weights,capacity,index+1,currVal)
    #print(values,weights,capacity,index,case1,case2)
    mem[(capacity,index)] = max(case1,case2)
    return mem[(capacity,index)]

def knapSack(values,weights,capacity):
    return helper(values,weights,capacity,0,0)


print(knapSack([100],[1],5))
print(knapSack([100,200,300],[1,2,3],5))