'''
PROBLEM 1

TIME COMPLEXITY: O(N)
SPACE COMPLEXITY: O(N)

- traverse the array while saving the target-nums[i] and corresponding index into a dictionary
- for every new element, check if its in the dictionary, if it is, then return current index and dict[target-nums[i]]
- if not present, keep adding target-nums[i] and corresponding index into a dictionary

'''
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        

        dicti={}
        result=[]
        # dicti[0]=1
        # if 0 in dicti:
        #     print("its there")
        for i in range(len(nums)):
            
            value=target-nums[i]


            if nums[i] in dicti: 
                # print(dicti)
                result.append(dicti[nums[i]])
                result.append(i)
                return result
            else:
                dicti[value]=i

'''
PROBLEM 1

TIME COMPLEXITY: O(W * length of weights array)
SPACE COMPLEXITY: O(W * length of weights array)

- build up a dp matrix where dp[i][j] denotes the maximum weights that can be attained until that point
- the rows denote the available weights and coloumns denote the maximum weight that can be attained
- return the last corner value of the matrix

'''


# values:[60, 100, 120]
# weights: [2, 3, 5]

# W=8

# Values weights    0   1   2   3   4   5   6   7   8
#         0         0   0   0   0   0   0   0   0   0
# 60      2         0   0   60  60  60  60  60  60  60
# 100     3         0   0   60  100 100 160 160 160 160
# 120     5         0   0   60  100 100 160 160 


# if max(dp[i-1],[0], dp[i-1][1] - dp[i-1][0], )


class Solution:
    def knapsack(self, weights, values, W):

        dp=[[0 for i in range(W+1)] for j in range(len(weights)+1)]

        # print(dp)
        for i in range(0, len(weights)):
            for j in range(1, W+1):

                if weights[i] > j:
                    dp[i+1][j] = dp[i][j]
                else:
                    dp[i+1][j]= max(dp[i][j], values[i] + dp[i][j-weights[i]])
        
        
        return dp[i+1][W]

values= [60, 100, 120]
weights= [2, 3, 5]
obj=Solution()
print(obj.knapsack(weights, values, 8))