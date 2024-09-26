#Problem 1: knapstack
#Time Complexity O(max_weight*n) , being the values
#Space complexity O(max_weight*n)
'''
Main idea:
DP matrix rows with the values and columns
weights 0,1,2,...,max_weight.
If weight< weights_of_current_index, we copy from the row above
Else, we check if it's better to copy from row above, or take
the optimal solution from the same row at index weight-weights_of_current_index
plus the current value. We return the final element.
'''
def knapstack(values,weights,max_weight):
    #edge case
    if not values:
        return 0
    dp=[[0]*(max_weight+1) for i in range(len(values))]
    for i in range(len(dp[0])):
        if i<weights[0]:
            dp[0][i]=0
        else:
            dp[0][i]=values[0]

    for i in range(1,len(dp)):
        for j in range(1,len(d[0])):
            if j<weights[i]:
                dp[i][j]=dp[i-1][j]
            else:
                dp[i][j]=max(dp[i-1][j-weights[i]]+values[i],dp[i-1][j])
    return dp[-1][-1]


#Problem 2: TwoSum
#Time Complexity O(n)
#Space complexity O(n)
'''
Main idea: Traverse through the array and check if target-num
is in the hasmap. If so return the index. If not append num
to the hashmap with it's index as value.
'''
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:

        h={}
        for i,num in enumerate(nums):
            if target-num in h:
                return [i,h[target-num]]
            else:
                h[num]=i
