public class Driver {

    public static void main(String[] args) {

        Tree intTree = new Tree();
//        intTree.search(89);
        System.out.println(intTree.max());

        intTree.insert(25);
        intTree.insert(22);
        intTree.insert(29);
        intTree.insert(21);
        intTree.insert(37);
        intTree.insert(28);
        intTree.insert(31);

        System.out.println("Inorder.....");
        intTree.displayInorderTraversal();
        System.out.println();
        System.out.println("Pre order.....");
        intTree.displayPreorderTraversal();
        System.out.println();
        System.out.println("Post order.....");
        intTree.displayPostOrderTraversal();
        System.out.println();
        System.out.println(intTree.search(25));
        System.out.println(intTree.search(28));
        System.out.println(intTree.search(11));
        System.out.println(intTree.search(31));

        System.out.println(intTree.max());
        System.out.println("The size is :"+intTree.size());

    }
}

// max value in the BST
// size of the BST
// height of the BST
// number of leaf nodes in the BST