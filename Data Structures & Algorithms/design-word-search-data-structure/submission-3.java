class WordDictionary {

    //index -> c (26 lowercase)
    //end: flag
    //addword: char[] -> add one by one
    //search 
    //traverse form root
    // c -> move to the next node
    // '.' -> traverse every node in this layer(bfs)
    // '.' traverse each path (recursive dfs)



    class Node {
        Node[] nodes = new Node[26];
        boolean end = false;

        public Node(){

        }
    }

    Node root;

    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        char[] chars = word.toCharArray();
        Node node = root;
        for(char c: chars){
            int index = c - 'a';
            if (node.nodes[index] == null) {
                node.nodes[index] = new Node();
            }
            node = node.nodes[index];
        }
        node.end = true;
    }

    class Pair {
        Node node;
        int index;

        Pair(Node node, int index) {
        this.node = node;
        this.index = index;
        }
    }

    public boolean search(String word) {
        char[] chars = word.toCharArray();
        Queue<Pair> queue = new LinkedList();
        queue.offer(new Pair(root, 0));
        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            Node node = pair.node;
            int index = pair.index;
            if(index == word.length()){
                return node.end;
            }
            if(chars[index] == '.'){
                for(int i = 0; i < node.nodes.length; i++){
                    if(node.nodes[i] != null){
                        queue.offer(new Pair(node.nodes[i], index + 1));
                    }
                }
            } else {
                int idx = chars[index] - 'a';
                if(node.nodes[idx] != null){
                    queue.offer(new Pair(node.nodes[idx], index + 1));
                }
            }
        }
        return false;
    }


}
