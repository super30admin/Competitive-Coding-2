class Solution(object):
    # Time complexity : O(n!)
    # Space Complexity: O(n^2)
    def __init__(self):
        self.ans = []
    def solveNQueens(self, n):
        """
        :type n: int
        :rtype: List[List[str]]
        """
        board = [[False for x in range(n)] for y in range(n)]
        self.helper(board, 0)
        return self.ans
    def helper(self, board, r):
        #print(board)
        if r == len(board):
            temp = []
            for i in range(len(board)):
                row = ''
                for j in range(len(board[0])):
                    if board[i][j] == True:
                        row += 'Q'
                    else:
                        row += '.'
                temp.append((row))
            self.ans.append((temp))
        for j in range(len(board[0])):
            if self.isSafe(board, r, j):
                board[r][j] = True
                self.helper(board, r+1)
                board[r][j] = False
    def isSafe(self, board, r, j):
        for i in range(0, r):
            if board[i][j] == True:
                return False
        row = r-1
        col = j-1
        while (row>=0 and col >=0):
            if board[row][col] == True:
                return False
            row -= 1
            col -= 1
        row = r-1
        col = j+1
        while row>=0 and col < len(board[0]):
            if board[row][col] == True:
                return False
            row -= 1
            col += 1
        return True
