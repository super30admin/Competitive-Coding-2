# Time Complexity : 2 ^^ (n+m)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution(object):
    def bag(self,weights,values, capacity):
        return self.helper(weights,values,capacity,0,0)
        
    def helper(self,weights,values,capacity,index,profit):

        # base case

        if capacity == 0:
            return profit
        
        if capacity <=0 or index>=len(weights):
            return -1

        # logic

        #No-choose
        case0 = self.helper(weights,values,capacity, index+1, profit)

        #choose
        case1 = self.helper(weights,values, capacity-weights[index], index+1, values[index]+profit)

        if case0 == -1:
            return case1
        if case1 == -1:
            return case0

        return max(case0,case1)

obj = Solution()
weights=[1,2,3]
values=[6,10,12]
capacity = 5

max = obj.bag(weights,values,capacity)
print(max)
        