public class Tree {

    private Node root;

    public void insert(int value) {
        if (root == null)
            root = new Node(value, null);
        else {
            root.insert(value);
        }
    }

    public void delete(int value) {
        if (root == null)
            throw new RuntimeException("The tree is empty");
        else {
            delete(value, root);
        }
    }

    private void delete(int value, Node node) {
        if (node == null)
            return;

        // reach the node where the value to be deleted is present
        if (value < node.getData()) {
            if (null != node.getLeftChild())
                delete(value, node.getLeftChild());
        } else if (value > node.getData()) {
            if (null != node.getRightChild())
                delete(value, node.getRightChild());
        } else {
            // we have reached to the node which is supposed to be deleted

            // case 1 (Node to be deleted is leaf node)
            if (null == node.getLeftChild() && null == node.getRightChild()) {
                Node par = node.getParent();
                // checking if node to be deleted is left child of parent
                if (null != par && par.getLeftChild() == node) {
                    par.setLeftChild(null);
                }
                // checking if node to be deleted is right child of parent
                else if (null != par && par.getRightChild() == node) {
                    par.setRightChild(null);
                }

                // the node to be deleted is root node and root is also a leaf node
                if (par == null)
                    root = null;
            }
            // Node to be deleted is having exactly one child
            else if (null != node.getLeftChild() && null == node.getRightChild()) {
                Node par = node.getParent();
                if (null != par && par.getLeftChild() == node) {
                    par.setLeftChild(node.getLeftChild());
                }
                // checking if node to be deleted is right child of parent
                else if (null != par && par.getRightChild() == node) {
                    par.setRightChild(node.getLeftChild());
                }

                if (par == null)
                    root = par.getLeftChild();

                node.getLeftChild().setParent(par);
                node = null;
            }
            // Node to be deleted is having exactly one child
            else if (null == node.getLeftChild() && null != node.getRightChild()) {
                Node par = node.getParent();
                if (null != par && par.getLeftChild() == node) {
                    par.setLeftChild(node.getRightChild());
                }
                // checking if node to be deleted is right child of parent
                else if (null != par && par.getRightChild() == node) {
                    par.setRightChild(node.getRightChild());
                }

                if (par == null)
                    root = par.getRightChild();

                node.getRightChild().setParent(par);
                node = null;
            } else {
                // case 3 : Node to be deleted has two children
                Node predecessor = getPredecessor(node.getLeftChild());
                int temp = node.getData();
                node.setData(predecessor.getData());
                predecessor.setData(temp);

                delete(value, predecessor);
            }
        }
    }

    private Node getPredecessor(Node node) {
        if (node.getRightChild() == null)
            return node;

        return getPredecessor(node.getRightChild());
    }

    public void displayPreorderTraversal() {
        if (root != null)
            root.preOrderTraversal();
    }

    public void displayInorderTraversal() {
        if (root != null)
            root.inOrderTraversal();
    }

    public void displayPostOrderTraversal() {
        if (root != null)
            root.postOrderTraversal();
    }

    public boolean search(int value) {
        if (root != null)
            return root.search(value);
        throw new RuntimeException("Cannot perform search in an empty tree");
    }

    public int max() {
        if (root != null)
            return root.max();
        else {
            return Integer.MIN_VALUE;
        }
    }

    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null)
            return 0;
        return size(node.getLeftChild()) + size(node.getRightChild()) + 1;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }
}
