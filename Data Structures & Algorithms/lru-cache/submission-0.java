class Node{
    int key;
    int value;
    Node prev;
    Node next;

    public Node(int key, int value){
        this.key = key;
        this.value = value;
        prev = null;
        next = null;
    }
}

class LRUCache {
    int capacity;
    Map<Integer,Node> cacheMap;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        cacheMap = new HashMap<>();
        this.capacity = capacity;
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        this.head.next = tail;
        this.tail.prev = head;
    }
    
    public int get(int key) {
        if(!cacheMap.containsKey(key)) return -1;

        Node node = cacheMap.get(key);
        remove(node);
        add(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if(cacheMap.containsKey(key)){
            Node oldNode = cacheMap.get(key);
            remove(oldNode);
        }

        Node newNode = new Node(key, value);
        cacheMap.put(key, newNode);
        add(newNode);

        if(cacheMap.size() > capacity){
            Node nodeToDel = tail.prev;
            remove(nodeToDel);
            cacheMap.remove(nodeToDel.key);
        }
    }

    public void add(Node node){
        Node nextNode = head.next;
        head.next = node;
        node.prev = head;
        node.next = nextNode;
        nextNode.prev = node;
    }

    public void remove(Node node){
        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }
}
