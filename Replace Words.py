#Time Complexity: O(n*k); n- number of words in the dictionary, k- avg length of the words
# Search time complexity: len(sentence)
# Space complexity: O(n*k); n- number of words in the dictionary, k- avg length of the words
class Solution(object):
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
    def startsWith(self, prefix):
        """
        :type prefix: str
        :rtype: bool
        """
        ans = ''
        curr = self.root
        for ch in prefix:
            #print(ch, curr.isEnd)
            c = ord(ch) - 97
            if curr.children[c] == None:
                break
            ans += ch
            if curr.children[c].isEnd == True:
                return ans
            curr = curr.children[c]
        return ''
    def replaceWords(self, dictionary, sentence):
        """
        :type dictionary: List[str]
        :type sentence: str
        :rtype: str
        """
        for word in dictionary:
            self.insert(word)
        words = sentence.split(" ")
        for i in range(len(words)):
            rep = self.startsWith(words[i])
            #print(rep)
            if rep != '':
                words[i] = rep
        return ' '.join(words)
            
            
        
