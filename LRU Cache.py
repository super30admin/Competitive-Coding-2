# Remove time complexity: O(1)
# Add time complexity: O(1)
# Space Complexity: O(capacity)
class LRUCache(object):
    class Node(object):
        def __init__(self, key, val, prev = None, nxt = None):
            self.val = val
            self.key = key
            self.prev = prev
            self.next = nxt       
    def add_to_head(self, node):
        node.prev = self.head
        node.next = self.head.next
        self.head.next.prev = node
        self.head.next = node
    def removeNode(self, node):
        node.prev.next = node.next
        node.next.prev = node.prev
        
    def __init__(self, capacity):
        """
        :type capacity: int
        """
        self.head = self.Node(-1, -1)
        self.tail = self.Node(-1, -1)
        self.head.next = self.tail
        self.tail.prev = self.head
        self.capacity = capacity
        self.hash = {}
        

    def get(self, key):
        """
        :type key: int
        :rtype: int
        """
        # print('get')
        # print(self.hash)
        if key in self.hash:
            node = self.hash[key]
            self.removeNode(node)
            self.add_to_head(node)
            return node.val
        else:
            return -1
        
        

    def put(self, key, value):
        """
        :type key: int
        :type value: int
        :rtype: None
        """
        if key in self.hash:
            # get the node from hash
            node = self.hash[key]
            #change the value of node
            node.val = value
            #remove it from it's place
            self.removeNode(node)
            # add it to the head
            self.add_to_head(node)
            
        else:
            new_node = self.Node(key, value)
            if len(self.hash) == self.capacity:
                # remove tail.prev
                tail_prev = self.tail.prev
                #remove it from the hashmap
                self.removeNode(tail_prev)
                del self.hash[tail_prev.key]
                #add the new node to hashmap
                self.hash[new_node.key] = new_node
                # add the new node to head
                self.add_to_head(new_node)
                
            else:
                # add the new node to hashmap
                # add it to head
                # print(new_node.key)
                # print(new_node.val)
                self.hash[new_node.key] = new_node
                self.add_to_head(new_node)
        # print('put')
        # print(self.hash)
        


# Your LRUCache object will be instantiated and called as such:self.
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)
