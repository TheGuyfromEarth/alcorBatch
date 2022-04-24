public class Tree {

    private Node root;

    public void insert(int value){
        if(root == null)
            root = new Node(value);
        else{
            root.insert(value);
        }
    }

    public void displayInorderTraversal(){
        if(root != null)
            root.inOrderTraversal();
    }
}
