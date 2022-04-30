public class Driver {

    public static void main(String[] args) {

        Heap heap = new Heap(6);
        heap.insert(31);
        heap.insert(21);
        heap.insert(13);
        heap.insert(18);
        heap.insert(8);
        heap.traverseHeap();
        System.out.println(heap.peek());

        heap.insert(55);

        heap.traverseHeap();

        System.out.println(heap.peek());
    }
}
