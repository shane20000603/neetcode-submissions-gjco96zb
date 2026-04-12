class PrefixTree {

    class Node {
        public Map<Character, Node> cache = new HashMap();
        public char ch;
        public boolean end = false;

        public Node(){}
        public Node(char c){
            this.ch = c;
        }
    }

    Node root;

    public PrefixTree() {
         root = new Node();
    }

    public void insert(String word) {
        char[] chars = word.toCharArray();
        Node dummy = root;
        for(int i = 0; i < chars.length; i++){
            Node c = dummy.cache.get(chars[i]);
            if(c == null){
                Node newNode = new Node(chars[i]);
                dummy.cache.put(chars[i], newNode);
                dummy = newNode;
            } else {
                dummy = c;
            }
        }
        dummy.end = true;
    }

    public boolean search(String word) {
        char[] chars = word.toCharArray();
        Node dummy = root;
        for(char c: chars){
            Node node = dummy.cache.get(c);
            if(node == null){
                return false;
            } else {
                dummy = node;
            }
        }
        return dummy.end;
    }

    public boolean startsWith(String prefix) {
        char[] chars = prefix.toCharArray();
        Node dummy = root;
        for(char c: chars){
            Node node = dummy.cache.get(c);
            if(node == null){
                return false;
            } else {
                dummy = node;
            }
        }
        return true;
    }
}
