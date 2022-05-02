public class Heap {

    private int[] heap;
    private int size;

    public Heap(int capacity) {
        heap = new int[capacity];
    }

    public int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    public int getChildIndex(int index, boolean leftChild) {
        return 2 * index + (leftChild ? 1 : 2);
    }

    public void insert(int value) {
        heap[size] = value;
        heapifyAbove(size);
        size++;
    }

    private void heapifyAbove(int index) {
        int parentIndex = getParentIndex(index);
        int value = heap[index];

        while (index > 0 && heap[parentIndex] < value) {
//            int temp = heap[parentIndex];
            heap[index] = heap[parentIndex];
//            heap[index] = temp;

            index = parentIndex;
            parentIndex = getParentIndex(index);
        }

        heap[index] = value;
    }

    public void traverseHeap() {

        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int peek() {
        if (isEmpty())
            throw new IllegalArgumentException("Heap is empty");

        return heap[0];
    }


    public int delete(int index) {

        if (isEmpty())
            throw new IllegalArgumentException("Heap is Empty");

        int lastHeapIndex = size - 1;
        int deletedValue = heap[index];
        // replacing the value to be deleted with rightmost leaf node (index)
        heap[index] = heap[lastHeapIndex];
        int parentIndex = getParentIndex(index);

        if (index == 0 || heap[index] < heap[parentIndex])
            heapifyBelow(index, lastHeapIndex);
        else
            heapifyAbove(index);

        size--;

        return deletedValue;
    }

    public void heapifyBelow(int index, int lastHeapIndex) {

        int childIndexToSwap;

        int leftChildIndex = 0;
        int rightChildIndex = 0;

        while (index <= lastHeapIndex) {

            leftChildIndex = getChildIndex(index, true);
            rightChildIndex = getChildIndex(index, false);
            // if the left child exists or not
            if (leftChildIndex <= lastHeapIndex) {
                // if the right child exists or not
                if (rightChildIndex > lastHeapIndex)
                    childIndexToSwap = leftChildIndex;
                else {
                    // both left and right child exists
                    if (heap[index] < heap[leftChildIndex] || heap[index] < heap[rightChildIndex]) {
                        childIndexToSwap = (heap[leftChildIndex] > heap[rightChildIndex]) ? leftChildIndex : rightChildIndex;
                    } else
                        break;
                }
                // swap logic
                int temp = heap[childIndexToSwap];
                heap[childIndexToSwap] = heap[index];
                heap[index] = temp;

                index = childIndexToSwap;
            } else
                break;
        }

    }

    public void sort(){
        int lastHeapIndex = size - 1; // 5
        for(int i = 0; i< lastHeapIndex; i++){
            int temp = heap[0];
            heap[0] = heap[lastHeapIndex - i];
            heap[lastHeapIndex - i] = temp;

            heapifyBelow(0, lastHeapIndex - i - 1);
        }
    }

}
