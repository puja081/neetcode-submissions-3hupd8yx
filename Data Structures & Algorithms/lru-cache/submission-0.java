public class Node {
    int key;
    int value;
    Node prev;
    Node next;
    public Node(int key, int value) {
         this.key = key;
         this.value = value;
         this.prev = null;
         this.next = null;
    }
}

class LRUCache {
    private int cap;
    private HashMap<Integer, Node> cache;
    private Node head;
    private Node tail;


    public LRUCache(int capacity) {
        this.cap = capacity;
        this.cache = new HashMap<>();
        this.head = new Node(0, 0);
        this.tail = new Node (0, 0);
        this.head.next = this.tail;
        this.tail.prev = this.head;   
    }

    public void insert(Node node) {
        Node curr = head.next;
        node.next = curr;
        curr.prev = node;
        node.prev = head;
        head.next = node;
        
    }

    public void remove(Node node){
        Node prevNode = node.prev;
        Node afterNode = node.next;
        prevNode.next = afterNode;
        afterNode.prev = prevNode;
    }
    
    public int get(int key) {
        if(!cache.containsKey(key)){return -1;}
        Node node = cache.get(key);
        remove(node);
        insert(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            remove(node);
            insert(node);
        } else if(cache.size() == this.cap) {
            Node currNode = this.tail.prev;
            cache.remove(currNode.key);
            remove(currNode);
        }
        Node node = new Node(key, value);
        cache.put(key, node);
        insert(node);
    }
}
