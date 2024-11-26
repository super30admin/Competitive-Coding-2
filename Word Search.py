class Solution(object):
    #Time Complexity : O(m*n*(3^(length of word)))
    #Space complexity: O(length of word)
    def exist(self, board, word):
        """
        :type board: List[List[str]]
        :type word: str
        :rtype: bool
        """
        dirs = [[0,1], [0, -1], [1, 0], [-1, 0]]
        for i in range(len(board)):
            for j in range(len(board[0])):
                if self.helper(board, 0, i, j, word, dirs):
                    return True
        return False
    def helper(self, board, index, x, y, word, dirs):
        # base conditions
        if index == len(word):
            return True
        if x<0 or x>=len(board) or y<0 or y>=len(board[0]):
            return False
        
        #logic
        #print(index, x, y)
        if word[index] == board[x][y]:
            temp = board[x][y]
            #action
            board[x][y] = '#'
            
            #Recurse
            for direction in dirs:
                cr = x+direction[0]
                cc = y+direction[1]
                if self.helper(board, index+1, cr, cc, word, dirs):
                    return True
            #backtrack
            board[x][y] = temp
        return False
            
            
            
            
        
        
        
