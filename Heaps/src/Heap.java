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

    public void traverseHeap(){

        for(int i = 0; i<size; i++){
            System.out.print(heap[i]+" ");
        }
        System.out.println();
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int peek(){
        if(isEmpty())
            throw new IllegalArgumentException("Heap is empty");

        return heap[0];
    }

    // in progress
    public int delete(int index){

        if(isEmpty())
            throw new IllegalArgumentException("Heap is Empty");

        int deletedValue = heap[index];
        heap[index] = heap[size-1];


        return deletedValue;
    }

    // in progress
    public void heapifyBelow(int index, int lastIndex){

        int leftChildIndex = getChildIndex(index,true);
        int rightChildIndex = getChildIndex(index,false);


    }

}
