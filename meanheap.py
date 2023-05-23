class MinHeap(object):

    def __init__(self):
        self.heap = []
        self.size = 0

    def getMin(self):
        if self.size <= 0:
            return -1
        return self.heap[0]

    def extractMin(self):
        if self.size <= 0:
            return -1
        minimum = self.heap[0]
        self.heap[0] = self.heap[self.size - 1]
        self.heap.pop()
        self.size -= 1
        self.__downHeapify()
        return minimum

    def insert(self, value):
        self.heap.append(value)
        self.size += 1
        self.__upHeapify()
        return

    def __getLeftChildIndex(self, index):
        return 2 * index + 1

    def __getRightChildIndex(self, index):
        return 2 * index + 2

    def __getParentIndex(self, index):
        return int((index - 1) / 2)

    def __hasLeftChild(self, index):
        return self.__getLeftChildIndex(index) < self.size

    def __hasRightChild(self, index):
        return self.__getRightChildIndex(index) < self.size

    def __hasParent(self, index):
        return self.__getParentIndex(index) >= 0

    def __getLeftChild(self, index):
        leftId = self.__getLeftChildIndex(index)
        return self.heap[leftId]

    def __getRightChild(self, index):
        rightId = self.__getRightChildIndex(index)
        return self.heap[rightId]

    def __getParent(self, index):
        parentId = self.__getParentIndex(index)
        return self.heap[parentId]

    def __swap(self, index1, index2):
        temp = self.heap[index1]
        self.heap[index1] = self.heap[index2]
        self.heap[index2] = temp

    def __downHeapify(self):
        currentId = 0
        while(self.__hasLeftChild(currentId)):
            smallerChildIndex = self.__getLeftChildIndex(currentId)     
            if (self.__hasRightChild(currentId) and self.__getRightChild(currentId) < self.__getLeftChild(currentId)):
                smallerChildIndex = self.__getRightChildIndex(currentId)
            if (self.heap[currentId] < self.heap[smallerChildIndex]):        
                break
            else:             
                self.__swap(currentId, smallerChildIndex)
            currentId = smallerChildIndex
        return

    def __upHeapify(self):
        currentId = self.size - 1
        while(self.__hasParent(currentId) and self.__getParent(currentId) > self.heap[currentId]):
            self.__swap(currentId, self.__getParentIndex(currentId))
            currentId = self.__getParentIndex(currentId)
        return
