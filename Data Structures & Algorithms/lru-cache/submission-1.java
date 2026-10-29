class Node{
    int key;
    int val;
    Node prev;
    Node next;

    public Node(int key, int val){
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}

class LRUCache {
    int capacity;
    Map<Integer,Node> cacheMap;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cacheMap = new HashMap();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;    
    }
    
    public int get(int key) {
        if(cacheMap.containsKey(key)){
            Node node = cacheMap.get(key);
            remove(node);
            add(node);

            return node.val;
        }

        return -1;
    }
    
    public void put(int key, int value) {
        if(cacheMap.containsKey(key)) remove(cacheMap.get(key));

        Node newNode = new Node(key,value);
        cacheMap.put(key, newNode);
        add(newNode);

        if(cacheMap.size() > capacity){
            Node lru = tail.prev;
            remove(lru);
            cacheMap.remove(lru.key);
        }
    }

    public void add(Node node){
        Node nextNode = head.next;
        head.next = node;
        node.next = nextNode;
        node.prev = head;
        nextNode.prev = node;
    }

    public void remove(Node node){
        Node nextNode = node.next;
        Node prevNode = node.prev;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }
}
