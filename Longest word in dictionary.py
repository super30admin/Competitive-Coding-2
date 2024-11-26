#Time Complexity: O(n*k)
#Space Compllexity: O(n*k)
class Solution(object):
    class TrieNode(object):
        def __init__(self):
            self.children = [None]*26
            #self.isEnd = False
            self.word = ''

    def __init__(self):
        self.root = self.TrieNode()
        self.ans = ''
        

    def insert(self, word):
        """
        :type word: str
        :rtype: None
        """
        is_true = True
        curr = self.root
        for i in range(len(word)):
            c = ord(word[i]) - 97
            if curr.children[c] != None:
                curr = curr.children[c]
            else:
                curr.children[c] = self.TrieNode()
                curr = curr.children[c]
            #print(word[i], curr.isEnd)
        curr.word = word
    def longestWord(self, words):
        """
        :type words: List[str]
        :rtype: str
        """
        #ords.sort()
        for word in words:
            self.insert(word)
        queue = []
        queue.append(self.root)
        curr = None
        while len(queue) != 0:
            curr = queue.pop(0)
            for i in range(25, -1, -1):
                if curr.children[i] != None and curr.children[i].word != '':
                    queue.append(curr.children[i])
        return curr.word
            
        
        #return self.ans
        
