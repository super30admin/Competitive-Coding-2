#knapsack 0/1
def main(weight,values,W):
    return helper(weight,values,W,0,0)

def helper(weight,values,W,totalAmount,i): #O(2^m*n)
    #base case
    if W < 0 :
        return -1
    if W == 0 or i == len(weight):
        return totalAmount
    
    
    #logic
    
    pick = helper(weight,values,W-values[i],totalAmount+weight[i],i+1)
    no_pick = helper(weight,values,W,totalAmount,i+1)
    
    if pick == -1:
        return no_pick
    if no_pick == -1:
        return pick
    
    return max(pick,no_pick)

weight = [60,100,120]
values = [10,20,30]
W = 50
print(main(weight,values,W))