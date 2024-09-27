"""
Time complexity 2^n
Space Complexity O(1)

"""



def knapSack(W, wei, val, i): 
  
    # Base Case 
    #When traversed all element in val and when weight becomes zero 
    if i ==len(val) or W == 0 : 
        return 0
    #when weight of current indx greater than W , we move to next index
    if (wei[i] > W): 
        return knapSack(W, wei, val, i+1) 
    #logic
    #find the max weight between picking the current value and not picking the current value.
    else: 
        return max(val[i] + knapSack(W-wei[i], wei, val, i+1), knapSack(W, wei, val, i+1)) 
  

val = [60, 100, 120] 
wei = [10, 20, 30] 
W = 50 
print(knapSack(W, wei, val, 0))