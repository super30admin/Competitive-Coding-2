# Time Complexity : O(NK), K is the capacity 
# Space Complexity :O(NK), K is the capacity

# Did this code successfully run on Leetcode : 
# YEs

# Any problem you faced while coding this : 

# Your code here along with comments explaining your approachclass Solution:


def max_array_value(l,v,c ) :
    #case 0 capacity 
    if c == 0: 
        return 0
    if len(l) == 0 :
        return 0 
    #base case, initialaztion array 
    max_array = [[0 for x in range(c+1)] for y in range(len(l)+1)]
    
    #Assign value
    for i in range(1, len(l)+1):
        for j in range( 1, c+1):
            #if item is not choosen
            if (j < l[i-1]):
                max_array[i][j] = max_array[i-1][ j]
            # if item is choosen and max compared
            else :
                max_array[i][j]= max(max_array[i-1][j] , v[i-1]+ max_array[i-1][j- l[i-1]] )
    return max_array[i][j] 
