// Given a set of words, return the most repeated word in the set.
// EX: {java,python,java,sql,python,java,php}
// O/P: java -> 3

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class MaxFrequencyWord {

    static String maxFreqWord = "";
    static int maxCount = 0;

    public static void main(String[] args) {
        Trie trie = new Trie();
        List<String> words = Arrays.asList("java", "python", "java", "sql", "python", "java", "php");
        for (String word : words)
            trie.insert(word);

        // traversing and find max count word
        dfs(trie.getRoot(), "", 0);
        System.out.println(maxFreqWord + " -> " + maxCount);
    }

    private static void dfs(Node node, String currWord, int maxCount) {
        if (node.isEndofWord() && node.getCount() > maxCount) {
            // print the word
            MaxFrequencyWord.maxCount = node.getCount();
            maxFreqWord = currWord;
        }

        Map<Character, Node> childMap = node.getChildren();
        for (char ch : childMap.keySet()) {
            dfs(childMap.get(ch), currWord + ch, maxCount);
        }
    }
}
