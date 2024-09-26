# Time Complexity :O(m*n)
# Space Complexity :O(m*n)
# Did this code successfully run on Leetcode : no
# Any problem you faced while coding this : no


# Your code here along with comments explaining your approach
def knapsack(w,v,cap):
    #no arrays
    if not w: 
        return 0
    #create a dp array to save taking and not taking each way
    dp = [[0]*(cap+1) for i in range( len(w)+1)]
    for i in range(1,len(dp)):
        for j in range(1,len(dp[0])):
            # if the weight you are trying to fill is less than weight of object don't take this object
            if j<w[i-1]:
                dp[i][j] = dp[i-1][j]
            else:
            #check the max between not taking the object and taking the object and put it in dp
                dp[i][j] = max(dp[i-1][j], (v[i-1]+ dp[i-1][j-w[i-1]]))
    #return the max bwtween them
    return dp[-1][-1]



testcases = [[[1, 5, 2, 6], [20, 20, 30, 50], 8],
             [[1, 8, 12, 6], [40, 13, 45, 10], 20],
             [[48, 72, 30, 52, 80, 58, 92, 55, 85, 50, 35, 60, 82, 64, 88, 37, 99, 94, 91, 39, 42, 97, 45, 47, 69, 61, 57, 40, 41, 86, 77, 54, 98, 87, 63, 70, 76, 93, 67, 46, 43, 59, 73, 71, 62, 51, 33, 89, 38, 49], [166, 114, 159,154, 94, 191, 105, 64, 23, 42, 18, 129, 185, 133, 171, 134, 168, 16, 68, 11, 80, 150, 62, 47, 182, 142, 93, 112, 137, 33, 153, 11, 99, 180, 176, 49, 105, 152, 180, 124, 160, 29, 62, 197, 28, 45, 37, 119, 32, 147], 456]]
for i in testcases:
    print(knapsack(*i))