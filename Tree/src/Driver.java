public class Driver {

    public static void main(String[] args) {

        Tree intTree = new Tree();
        intTree.insert(25);
        intTree.insert(22);
        intTree.insert(29);
        intTree.insert(21);
        intTree.insert(37);
        intTree.insert(28);
        intTree.insert(31);

        intTree.displayInorderTraversal();

    }
}
