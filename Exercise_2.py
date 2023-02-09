#Time Complexity : O(M*N), N being the length of the array and M the max weight. 
#Space Complexity : O(M*N), N being the length of the array and M the max weight. 
#Did this code successfully run on Leetcode : Did not find link for leetcode. 
#Any problem you faced while coding this : Had a great deal of issue with indices and 
# and with the setting up of the dp problem in general. I definitely need more practice
# with dp problems. 

#Your code here along with comments explaining your approach in three sentences only
'''Create a 2D dp array, length of array by max of weight. Fill the values in the array
if it's not allready filled. Then take the max of everything in the array. 
'''
class Knapsack:
    def helper(self, values, weights, W, w, v, index, dp):
        #fill the dp array if value is 0. 
        if w==W:
            dp[index][w] = v
        elif w>W:
            return -1
        elif index>=len(values):
            return -1
        else:
            if dp[index][w] == 0:
                dp[index][w] = v
            if w+weights[index]<=W:
                if dp[index][w+weights[index]] == 0:
                    dp[index][w+weights[index]] = v+values[index]
                        
            self.helper(values, weights, W, w, v, index+1, dp)
            self.helper(values, weights, W, w+weights[index], v+values[index], index+1, dp)

    def knapsack(self, values, weights, W):
        # initialize dp array. 
        dp = [[0 for i in range(W+1)] for j in range(len(weights)+1)]
        #call helper function. 
        self.helper(values, weights, W, 0, 0, 0, dp)
        result = 0
        #result is max of dp values. 
        for i in range(len(weights)+1):
            temp_max = max(dp[i])
            if result<temp_max:
                result = temp_max
        return result

values = [60,100,120]
weights = [10, 20, 30]
W=50

k = Knapsack()
result = k.knapsack(values, weights, W)

print(result)
