public class Node {

    private int data;
    private Node leftChild;
    private Node rightChild;
    private Node parent;

    public Node(int data,Node parent) {
        this.data = data;
        this.parent = parent;
    }

    public void insert(int value) {
        // root node exists

        // to handle duplicate value
        if (value == data)
            return;

        if (value < data) {
            // check the left child of this node
            if (leftChild == null) {
                leftChild = new Node(value,this);
            } else {
                leftChild.insert(value);
            }
        } else {
            // check the right child of this node
            if (rightChild == null) {
                rightChild = new Node(value,this);
            } else {
                rightChild.insert(value);
            }
        }

    }

    public void preOrderTraversal() {

        System.out.print(data + " ");

        if (leftChild != null)
            leftChild.preOrderTraversal();

        if (rightChild == null)
            return;
        else {
            rightChild.preOrderTraversal();
        }
    }

    public void inOrderTraversal() {

        if (leftChild != null)
            leftChild.inOrderTraversal();

        System.out.print(data + " ");

        if (rightChild == null)
            return;
        else {
            rightChild.inOrderTraversal();
        }
    }

    public void postOrderTraversal() {

        if (leftChild != null)
            leftChild.postOrderTraversal();

        if (rightChild != null)
            rightChild.postOrderTraversal();

        System.out.print(data + " ");
    }

    public boolean search(int value) {
        if (value == data)
            return true;
        else if (value < data) {
            if (leftChild != null)
                return leftChild.search(value);
        } else {
            if (rightChild != null)
                return rightChild.search(value);
        }
        return false;
    }

    public int max(){
        if(rightChild == null)
            return data;
        else
            return rightChild.max();
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }
}
