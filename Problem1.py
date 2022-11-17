from typing import List
import sys
# Time Complexity : O(m*n), Where m is W, n is number of elements in val List
# Space Complexity : O(m*n), Where m is W, n is number of elements in val List
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Nothing specific

def knapsack_helper(index: int,W: int,wt: List[int],val: List[int],memo: List[List[int]])->int:
    
    if(index==len(wt)):
        if(W==0):
            return 0
        else:
            return -sys.maxsize-1
    if(W<0):
        return -sys.maxsize-1
    #If the answer is available then we can just return the value rather than computing    
    if(memo[index][W]!=None):
        return memo[index][W]

    #We choose not take the element at that index
    l=0+knapsack_helper(index+1,W,wt,val,memo)
    #We choose to take element at that index
    r=val[index]+knapsack_helper(index+1,W-wt[index],wt,val,memo)

    memo[index][W]=max(l,r)
    return max(l,r)


def knapsack(index: int,W: int,wt: List[int],val: List[int])->int:
    memo=[ [None for i in range(W+1)] for j in range(len(wt))]
    print(memo)
    ans=knapsack_helper(index,W,wt,val,memo)
    print("after")
    print(memo)
    return ans
    
if __name__ == "__main__":
 
    val = [60,100,120]
    wt = [10,20,30]
    W = 50
 
    print(knapsack(0,W, wt, val))