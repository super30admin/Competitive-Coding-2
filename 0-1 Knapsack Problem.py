# Time: O(2^n) in worst case each call spawns 2 recursive calls
# Space: O(n) recursion is almost n calls deep
class Solution:
    def knapSack(self, W: int, weights: List[int], profits: List[int]) -> int:
        return self.helper(W, weights, profits, 0)
    def helper(self, w, weights, profits, idx):
        # base
        if idx >= len(weights) or w <= 0:
            return 0
        if weights[idx] > w:
            return self.helper(w, weights, profits, idx + 1)

        # not choose    
        not_choose = self.helper(w, weights, profits, idx + 1)
        # choose
        choose = profits[idx] + self.helper(w - weights[idx],weights, profits, idx +1)

        return max(choose,not_choose)
    

# TABULATION APPROACH
# Time and Space:O(m*n) m is the max capacity and n is the number of elements in weights array
# If the current capacity is less than the weights then just copy the previous row (not_choose)
# If not then the current element is maximum between the previous element(not_choose) and profits at curr( ie. choose) + the value required to make the remaining amount which will be in the previous row
class Solution:
    def knapSack(self, W: int, weights: List[int], profits: List[int]) -> int:
        dp_matrix = [[0 for _ in range(W + 1)]for _ in range(len(weights) + 1)]

        for i in range(1,len(dp_matrix)):
            for j in range(1,len(dp_matrix[0])):
                if j < weights[i-1]:
                    dp_matrix[i][j] = dp_matrix[i-1][j]
                else:
                    dp_matrix[i][j] = max(dp_matrix[i-1][j],profits[i-1] + dp_matrix[i-1][j - weights[i-1]])

        return dp_matrix[len(dp_matrix)-1][len(dp_matrix[0])-1]