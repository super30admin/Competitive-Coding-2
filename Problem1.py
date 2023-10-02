'''
Pascal's Triangle
1. We initialize the first row with 1.
2. From the second row onwards, we add 1 at the beginning and end of the row, and for the rest of the elements, we add the sum of the elements of the above it from the previous row. For ith row jth element, we add (i-1)th row (j-1)th element and (i-1)th row jth element.

TC: O(n^2)
SC: O(n)
'''

class Solution:
    def generate(self, numRows: int) -> List[List[int]]:
        pt = [[1]]
        if numRows == 1:
            return pt        
        for i in range(1,numRows):
            row = []
            row.append(1)
            for j in range(1,i):
                row.append(pt[i-1][j-1]+pt[i-1][j])
            row.append(1)
            pt.append(row)
        return pt