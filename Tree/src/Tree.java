public class Tree {

    private Node root;

    public void insert(int value){
        if(root == null)
            root = new Node(value,null);
        else{
            root.insert(value);
        }
    }

    public void displayPreorderTraversal(){
        if(root != null)
            root.preOrderTraversal();
    }

    public void displayInorderTraversal(){
        if(root != null)
            root.inOrderTraversal();
    }

    public void displayPostOrderTraversal(){
        if(root != null)
            root.postOrderTraversal();
    }

    public boolean search(int value){
        if(root!=null)
           return root.search(value);
        throw new RuntimeException("Cannot perform search in an empty tree");
    }

    public int max(){
        if(root != null)
            return root.max();
        else{
            return Integer.MIN_VALUE;
        }
    }

    public int size(){
      return size(root);
    }

    private int size(Node node){
        if(node == null)
            return 0;
        return size(node.getLeftChild()) + size(node.getRightChild()) + 1;
    }

}
