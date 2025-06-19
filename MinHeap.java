
public class MinHeap {
    private int[] data;
    private int currentSize;
    private final int capacity;

    public MinHeap(int capacity) {
        this.capacity = capacity;
        this.currentSize = 0;
        this.data = new int[capacity];
    }

    private int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    private int getLeftChildIndex(int index) {
        return 2 * index + 1;
    }

    private int getRightChildIndex(int index) {
        return 2 * index + 2;
    }

    private boolean isLeafNode(int index) {
        return index >= currentSize / 2 && index < currentSize;
    }

    private void swap(int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    private void heapifyDown(int index) {
        if (isLeafNode(index)) return;

        int left = getLeftChildIndex(index);
        int right = getRightChildIndex(index);
        int smallest = index;

        if (left < currentSize && data[left] < data[smallest]) {
            smallest = left;
        }

        if (right < currentSize && data[right] < data[smallest]) {
            smallest = right;
        }

        if (smallest != index) {
            swap(index, smallest);
            heapifyDown(smallest);
        }
    }

    public void add(int value) {
        if (currentSize >= capacity) {
            System.out.println("Heap is full. Cannot insert " + value);
            return;
        }

        data[currentSize] = value;
        int index = currentSize;
        currentSize++;

        // Bubble up
        while (index > 0 && data[index] < data[getParentIndex(index)]) {
            swap(index, getParentIndex(index));
            index = getParentIndex(index);
        }
    }

    public int extractMin() {
        if (currentSize == 0) {
            throw new IllegalStateException("Heap is empty");
        }

        int min = data[0];
        data[0] = data[currentSize - 1];
        currentSize--;
        heapifyDown(0);
        return min;
    }

    public void display() {
        for (int i = 0; i <= (currentSize - 2) / 2; i++) {
            System.out.print("PARENT: " + data[i]);
            if (getLeftChildIndex(i) < currentSize)
                System.out.print(" | LEFT: " + data[getLeftChildIndex(i)]);
            if (getRightChildIndex(i) < currentSize)
                System.out.print(" | RIGHT: " + data[getRightChildIndex(i)]);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(15);

        int[] values = {12, 7, 6, 10, 15, 17, 20, 2, 5};

        System.out.println("Inserting values into Min Heap:");
        for (int val : values) {
            minHeap.add(val);
            System.out.println("Inserted: " + val);
        }

        System.out.println("\nCurrent Min Heap structure:");
        minHeap.display();

        System.out.println("\nExtracting min value: " + minHeap.extractMin());

        System.out.println("\nHeap after removing min:");
        minHeap.display();
    }
}

