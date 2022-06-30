public class Driver {

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("take");
        trie.insert("apple");
        trie.insert("taken");
        trie.insert("room");
        trie.insert("roman");
//        System.out.println(trie.search("take"));
//        System.out.println(trie.search("rom"));

        // print all the words present in the trie
        trie.printAllWords();
        trie.delete("take");
        trie.delete("took");
        System.out.println("After Deletion:");
        trie.printAllWords();
    }
}
