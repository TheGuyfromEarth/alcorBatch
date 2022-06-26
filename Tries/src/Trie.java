public class Trie {

    private Node root;

    public Trie(){
        root = new Node();
    }

    public void insert(String word){ // take
        Node currNode = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i); //e
            if(!currNode.getChildren().containsKey(ch)){
                Node node = new Node();
                currNode.getChildren().put(ch,node);
            }
            currNode = currNode.getChildren().get(ch);
        }
        currNode.setEndofWord(true);
    }
}
