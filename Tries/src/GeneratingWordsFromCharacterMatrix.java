// Given a character matrix and a dictionary, generate possible words from the character matrix
// if they are present in the dictionary and print them. Given that words can be generated
// by travelling north,south,east,west,north-west,north-east,south-west and south-east.
// Same character at same position cannot be used twice.

/* Ex: matrix = {
                    { 'k','f','i','p'},
                    { 'l','z','m','l'},
                    { 'o','s','i','k'},
                    { 't','n','z','y'},
                }
// dictionary = {"milk","silk","batman","silky","to","film"}

// O/P: "milk","silk","silky","to","film"
*/
public class GeneratingWordsFromCharacterMatrix {

    static int[] val = {-1, 0, 1};

    public static void main(String[] args) {
        String[] dictionary = {"milk", "silk","small","batman", "silky", "to", "film"};

        char[][] matrix = {
                {'k', 'f', 'i', 'p'},
                {'l', 'z', 'm', 'l'},
                {'o', 's', 'i', 'k'},
                {'t', 'n', 'z', 'y'},
        };

        setupTrieAndSearch(dictionary,matrix);
    }

    private static void setupTrieAndSearch(String[] dict, char[][] matrix) {

        Trie trie = new Trie();
        for (String word : dict)
            trie.insert(word);

        boolean[][] visited = new boolean[matrix.length][matrix[0].length];

        // iterating across matrix
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (trie.getRoot().getChildren().containsKey(matrix[i][j])) {
                    Node node = trie.getRoot().getChildren().get(matrix[i][j]);
                    searchWord(node, "" + matrix[i][j], matrix, i, j, visited);
                }
            }
        }
    }

    private static void searchWord(Node curNode, String word, char[][] matrix, int x, int y, boolean[][] visited) {
        // base condition
        if (curNode.isEndofWord()) {
            System.out.println(word);
        }

        visited[x][y] = true;

        // isReachable Position or not (for 8 possible directions)
        for (int i : val) {
            for (int j : val) {
                if (i == 0 & j == 0)
                    continue;
                else {
                    if (isSafe(matrix, x + i, y + j, visited, curNode)) {

                        searchWord(curNode.getChildren().get(matrix[x + i][y + j]), word + matrix[x + i][y + j], matrix, x + i, y + j, visited);
                    }
                }
            }
        }
        // backtrack
        visited[x][y] = false;
    }

    private static boolean isSafe(char[][] matrix, int i, int j, boolean[][] visited, Node node) {
        return i < matrix.length && j < matrix[0].length && i >= 0 && j >= 0 && !visited[i][j] && node.getChildren().containsKey(matrix[i][j]);
    }
}
