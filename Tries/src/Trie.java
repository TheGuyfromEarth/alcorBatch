import java.util.Map;

public class Trie {

    private Node root;

    public Trie() {
        root = new Node();
    }

    public Node getRoot(){
        return this.root;
    }

    public void insert(String word) { // take
        Node currNode = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i); //e
            if (!currNode.getChildren().containsKey(ch)) {
                Node node = new Node();
                currNode.getChildren().put(ch, node);
            }
            currNode = currNode.getChildren().get(ch);
        }
        currNode.setEndofWord(true);
        // for maxFreq Problem
        currNode.setCount(currNode.getCount()+1);
    }

    public boolean search(String word) {
        Node curr = root;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!curr.getChildren().containsKey(ch))
                return false;
            curr = curr.getChildren().get(ch);
        }
        return curr.isEndofWord();
    }

    public void printAllWords() {
        dfs(root, "");
    }

    private void dfs(Node node, String currWord) {
        if (node.isEndofWord()) {
            // print the word
            System.out.println(currWord);
        }

        Map<Character, Node> childMap = node.getChildren();
        for (char ch : childMap.keySet()) {
            dfs(childMap.get(ch), currWord + ch);
        }
    }

    public void delete(String word) {
        deleteUtil(root, word, 0);
    }

    private boolean deleteUtil(Node currNode, String word, int index) { // Bat, Bill
        if (index == word.length()) {
            // yes, the charcters are present
            if (currNode.isEndofWord()) {
                // word is also present in the trie
                currNode.setEndofWord(false);
                return currNode.getChildren().size() == 0;
            } else {
                // word was not inserted in the trie, hence should not be deleted
                return false;
            }
        }
        char ch = word.charAt(index);
        if (!currNode.getChildren().containsKey(ch))
            // word is not present
            return false;
        Node node = currNode.getChildren().get(ch);
        boolean shouldDelete = deleteUtil(node, word, index + 1);

        if (shouldDelete) {
            // the key value pair can be safely removed
            currNode.getChildren().remove(ch);
            return !currNode.isEndofWord() && currNode.getChildren().size() == 0;
        }
        return false;
    }
}

