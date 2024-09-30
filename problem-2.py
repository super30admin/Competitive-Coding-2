# Approach 1 : Recursive
# Every time we will choose or not choose the element if we choose same index will be passed to next
#recursive call else pass the next index to next recursive call.
# if amount is zero or index in greterthan len(weights) then return sum

# complexities
#Time Complexity : 2^(m+n)
#Space Complexity : o(1) + O(recursive auxillaryspace)


from typing import List


class Solution:
    def knapSack(self, weights: List[int],profit: List[int], target: int) -> int:
        return self.helper(weights,profit,target,0,0)

    def helper(self,weights,profit,target,total_sum,index):
        if target<=0 or index>= len(weights):
            return total_sum
        case0 = self.helper(weights,profit,target,total_sum,index+1)
        case1=0
        if (target -weights[index])>=0:
            case1 = self.helper(weights,profit,target-weights[index],total_sum+profit[index],index+1)

        return max(case0,case1)

# Approach 2 : Bottom-up(tabulation)
# We saw some sub problems in the recursive is repeating so there are 2 variables amount and denomination
# So create a 2-D array to reuse the already computed values
# in this convert recursive function for choose not choose contions and fill the dp array

# complexities
#Time Complexity : O(m*n)
#Space Complexity : O(m*n)

class Solution:
    def knapSack(self, weights: List[int],profit: List[int], target: int) -> int:
        dp = [[0 for _ in range(target+1)] for _ in range(len(weights)+1) ]
        for i in range(1,len(weights)+1):
            for j in range(1,target+1):
                case0 = dp[i-1][j]
                case1 =0
                if (j - weights[i-1]) >= 0:
                    case1 = profit[i-1]+dp[i][j-weights[i-1]]
                dp[i][j] = max(case0,case1)
            print(dp)
        return dp[len(weights)][target]


# Approach 3: Bottom-up(tabulation)(Space Optimaization)
# Since we are only depending on the previous row to compute the present row value we can eleminate remaining rows using 2-!D arrays

# complexities
#Time Complexity : O(m*n)
#Space Complexity : O(m)

class Solution:
    def knapSack(self, weights: List[int],profit: List[int], target: int) -> int:
        prev  = [0]*(target+1)
        for i in range(1,len(weights)+1):
            curr = [0] * (target + 1)
            for j in range(1,target+1):
                case0 = prev[j]
                case1 =0
                if (j - weights[i-1]) >= 0:
                    case1 = profit[i-1]+curr[j-weights[i-1]]
                curr[j] = max(case0,case1)

            prev = curr
        return prev[target]


s = Solution()
print(s.knapSack([1,2,3],[1,7,11],5))


