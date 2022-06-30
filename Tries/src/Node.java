import java.util.HashMap;
import java.util.Map;

public class Node {

    private Map<Character, Node> children;
    private boolean isEndofWord;
    // for maxFreq problem
    private int count;

    public Node() {
        this.children = new HashMap<>();
        this.isEndofWord = false;
    }

    public Map<Character, Node> getChildren() {
        return children;
    }

    public void setChildren(Map<Character, Node> children) {
        this.children = children;
    }

    public boolean isEndofWord() {
        return isEndofWord;
    }

    public void setEndofWord(boolean endofWord) {
        isEndofWord = endofWord;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
