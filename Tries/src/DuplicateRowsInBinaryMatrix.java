// Given a binary matrix, we need to identify the duplicate rows and print the duplicate row numbers.

// EX: matrix = {
//                    {0,1,0,1},
//                    {1,0,1,1},
//                    {0,1,0,1},
//                    {1,0,1,1}
//              }

// O/P: 3,4

import java.util.HashSet;

public class DuplicateRowsInBinaryMatrix {

    public static void main(String[] args) {

        int[][] matrix = {
                    {0,1,0,1},
                    {1,0,1,1},
                    {0,1,0,1},
                    {1,0,1,1}
              };


        // without trie
        HashSet<String> set = new HashSet<>();

       Trie trie = new Trie();

       for(int i=0;i< matrix.length;i++){
           String word = "";
           for(int j=0;j<matrix[i].length;j++){
               word+=matrix[i][j];
           }
//           if(insert(word,trie))
//               System.out.println(i+1);
           if(isDuplicate(word,set))
               System.out.println(i+1);
       }


    }

    private static boolean insert(String word,Trie trie) {
        Node currNode = trie.getRoot();
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!currNode.getChildren().containsKey(ch)) {
                Node node = new Node();
                currNode.getChildren().put(ch, node);
            }
            currNode = currNode.getChildren().get(ch);
        }
        if(!currNode.isEndofWord()){
            currNode.setEndofWord(true);
        }
        else
            return true;

        return false;
    }

    // without trie
    private static boolean isDuplicate(String word,HashSet<String> set){

        if(set.contains(word))
            return true;
        else
            set.add(word);

        return false;
    }
}
