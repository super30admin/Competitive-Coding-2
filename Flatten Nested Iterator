# """
# This is the interface that allows for creating nested lists.
# You should not implement it, or speculate about its implementation
# """
#class NestedInteger(object):
#    def isInteger(self):
#        """
#        @return True if this NestedInteger holds a single integer, rather than a nested list.
#        :rtype bool
#        """
#
#    def getInteger(self):
#        """
#        @return the single integer that this NestedInteger holds, if it holds a single integer
#        Return None if this NestedInteger holds a nested list
#        :rtype int
#        """
#
#    def getList(self):
#        """
#        @return the nested list that this NestedInteger holds, if it holds a nested list
#        Return None if this NestedInteger holds a single integer
#        :rtype List[NestedInteger]
#        """

class NestedIterator(object):

    def __init__(self, nestedList):
        """
        Initialize your data structure here.
        :type nestedList: List[NestedInteger]
        """
        self.stack = []
        self.stack.append([nestedList, 0])
        self.next_element = -1
        

    def next(self):
        """
        :rtype: int
        """
        #self.hasNext()
        #print(self.stack)
        ret = self.next_element.getInteger()
        self.stack[-1][1] += 1
        return ret
            
        

    def hasNext(self):
        """
        :rtype: bool
        """
        while len(self.stack) != 0:
            if self.stack[-1][1] >= len(self.stack[-1][0]):
                self.stack.pop()
                if len(self.stack) != 0:
                    self.stack[-1][1] += 1
            else:
                next_element, cnt  = self.stack[-1]
                #self.stack[-1][1] += 1
                self.next_element = next_element[cnt]
                if self.next_element.isInteger():
                    return True
                else:
                    self.stack.append([self.next_element.getList(), 0])
        return False
                
            

        

# Your NestedIterator object will be instantiated and called as such:
# i, v = NestedIterator(nestedList), []
# while i.hasNext(): v.append(i.next())
