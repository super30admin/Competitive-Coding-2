class Solution:
    def Knapsack(self):
        wt = [1,2,3]
        w = 6
        p = [10,15,40]

        matrix = [[0 for i in range(w+1)] for j in range(len(wt)+1)]

        for i in range(1,len(wt)+1):
            for j in range(1,w+1):
                if j < wt[i-1]:
                    matrix[i][j] = matrix[i-1][j]
                else:
                    matrix[i][j] = max(matrix[i-1][j], p[i-1] + matrix[i-1][j- wt[i-1]])

        return matrix[len(wt)][w]
        
# TC: O(wt*w)
# SC: O(wt*w)