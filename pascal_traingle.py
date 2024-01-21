class Solution:
    def generate(self, numRows: int) -> List[List[int]]:
        lst = list()
        for i in range(numRows):
            row = [1] * (i+1)
            for j in range(1,i):
                row[j] = lst[i-1][j-1] + lst[i-1][j]
                #i = 1, j = 2, row(2) = lst[0][1]+ lst[0][2]
                #i = 2, j = 3, row(3) = lst[1][2]+ lst[1][3]
            lst.append(row)

        return lst
