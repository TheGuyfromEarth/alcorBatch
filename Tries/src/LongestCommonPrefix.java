// Given a set of words, find the longest common prefix across all the words.
// Ex: String[] arr = {"run","runnable","runs","running"};

import java.util.Map;

public class LongestCommonPrefix {

    public static void main(String[] args) {

        Trie trie = new Trie();
        trie.insert("run");
        trie.insert("runnable");
        trie.insert("runs");
        trie.insert("running");
        trie.insert("ruin");

        // traversal
        System.out.println(dfs(trie.getRoot(), ""));
    }

    private static String dfs(Node currNode, String lcf) {
        if (currNode.getChildren().size() > 1) {
            return lcf;
        }

        Map<Character, Node> childMap = currNode.getChildren();
        for (char ch : childMap.keySet()) {
            return dfs(childMap.get(ch), lcf + ch);
        }
        return lcf;
    }
}
