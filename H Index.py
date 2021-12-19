# Time Complexity: O(n)
# Space Complexity: O(# of papers)
class Solution(object):
    def hIndex(self, citations):
        """
        :type citations: List[int]
        :rtype: int
        """
        
        helper = [0]*(len(citations)+1)
        for i in citations:
            if i > len(citations):
                helper[len(citations)] += 1
            else:
                helper[i] += 1
        max_papers = 0
        for j in range(len(helper)-1, -1, -1):
            max_papers += helper[j]
            if max_papers >= j:
                return j

        return -1
            
        
