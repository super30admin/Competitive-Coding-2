#Recursive Solution
#Time Complexity - O(2^len(w))
#Space Complexity - len(w)
def knapsack(w,v,cap):
    
    def helper(index,curCap,ans):
        #base case
        if index >= len(w) or curCap == 0:
            return ans
        
        #case 1 choose
        case1 = 0
        if curCap-w[index] >= 0:
            case1 = helper(index+1,curCap-w[index],ans+v[index])
        case2 = helper(index+1,curCap,ans)
        return max(case1,case2)
    
    return helper(0,cap,0)
testcases = [[[1, 5, 2, 6], [20, 20, 30, 50], 8],
             [[1, 8, 12, 6], [40, 13, 45, 10], 20]]
for i in testcases:
    print(knapsack(*i))

#Finished in 20 ms
#80
#95

#Dynamic Programming Solution
#Time Complexity - O(len(w)+1*(cap+1))
#Space Complexity - O(len(w)+1*(cap+1))
def knapsack(w,v,cap):
    dp = []
    for i in range(len(w)+1):
        dp.append([0]*(cap+1))
    
    for i in range(1,len(dp)):
        for j in range(1,len(dp[0])):
            if j < w[i-1]:
                dp[i][j] = dp[i-1][j]
            else:
                dp[i][j] = max(dp[i-1][j],v[i-1]+dp[i-1][j-w[i-1]])
    return dp[-1][-1]


testcases = [[[1, 5, 2, 6], [20, 20, 30, 50], 8],
             [[1, 8, 12, 6], [40, 13, 45, 10], 20],
             [[48, 72, 30, 52, 80, 58, 92, 55, 85, 50, 35, 60, 82, 64, 88, 37, 99, 94, 91, 39, 42, 97, 45, 47, 69, 61, 57, 40, 41, 86, 77, 54, 98, 87, 63, 70, 76, 93, 67, 46, 43, 59, 73, 71, 62, 51, 33, 89, 38, 49], [166, 114, 159,154, 94, 191, 105, 64, 23, 42, 18, 129, 185, 133, 171, 134, 168, 16, 68, 11, 80, 150, 62, 47, 182, 142, 93, 112, 137, 33, 153, 11, 99, 180, 176, 49, 105, 152, 180, 124, 160, 29, 62, 197, 28, 45, 37, 119, 32, 147], 456]]
for i in testcases:
    print(knapsack(*i))

#Finished in 24 ms
#80
#95
#1506