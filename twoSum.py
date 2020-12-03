'''
Time complexity :0(N)
Space complexity :O(1)
'''
class Solution:
    def two_sum(self,array,target):
        d = {}
        for index,value in enumerate(array):
            if target -value in d:
                return [d[target-value],index]
            
            d[value] = index

s = Solution()
print(s.two_sum([2,7,11,15],9))
print(s.two_sum([3,2,4,6],6))

