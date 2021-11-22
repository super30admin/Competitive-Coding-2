# Search time complexity: O(len(word))
# Prefix time complexity: O(len(prefix))
class Trie(object):
    class TrieNode(object):
        def __init__(self):
            self.children = [None]*26
            self.isEnd = False

    def __init__(self):
        self.root = self.TrieNode()
        

    def insert(self, word):
        """
        :type word: str
        :rtype: None
        """
        curr = self.root
        for c in word:
            c = ord(c) - 97
            if curr.children[c] != None:
                curr = curr.children[c]
            else:
                curr.children[c] = self.TrieNode()
                curr = curr.children[c]
        curr.isEnd = True
                
                
        

    def search(self, word):
        """
        :type word: str
        :rtype: bool
        """
        curr = self.root
        for c in word:
            c = ord(c) - 97
            if curr.children[c] == None:
                return False
            curr = curr.children[c]
        return curr.isEnd
        

    def startsWith(self, prefix):
        """
        :type prefix: str
        :rtype: bool
        """
        curr = self.root
        for c in prefix:
            c = ord(c) - 97
            if curr.children[c] == None:
                return False
            curr = curr.children[c]
        return True
        
        


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)
