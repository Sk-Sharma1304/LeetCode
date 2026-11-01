import java.util.HashMap;

class LFUCache {

    /* ---------------- NODE CLASS ---------------- */
    // Represents one cache entry
    class Node {
        int key, value;
        int freq;           // access frequency
        Node prev, next;    // for doubly linked list

        Node(int k, int v) {
            key = k;
            value = v;
            freq = 1;       // new node always starts with frequency = 1
        }
    }

    /* -------- DOUBLY LINKED LIST CLASS -------- */
    // Each frequency has its own doubly linked list
    class DoublyLinkedList {
        Node head, tail;
        int size;

        DoublyLinkedList() {
            // Dummy head & tail to simplify add/remove
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        // Add node just after head (most recently used for this frequency)
        void addToHead(Node node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
            size++;
        }

        // Remove any node from the list
        void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

        // Remove least recently used node (tail.prev)
        Node removeLast() {
            if (size == 0) return null;
            Node last = tail.prev;
            remove(last);
            return last;
        }
    }

    /* ---------------- LFU CACHE DATA ---------------- */
    int capacity;                   // max size of cache
    int minFreq;                    // minimum frequency in cache
    HashMap<Integer, Node> nodeMap; // key -> Node
    HashMap<Integer, DoublyLinkedList> freqMap; // freq -> DLL

    /* ---------------- CONSTRUCTOR ---------------- */
    public LFUCache(int capacity) {
        this.capacity = capacity;
        minFreq = 0;
        nodeMap = new HashMap<>();
        freqMap = new HashMap<>();
    }

    /* ---------------- GET ---------------- */
    public int get(int key) {
        if (!nodeMap.containsKey(key))
            return -1;

        Node node = nodeMap.get(key);
        updateFrequency(node);   // increase frequency
        return node.value;
    }

    /* ---------------- PUT ---------------- */
    public void put(int key, int value) {
        if (capacity == 0) return;

        // If key already exists → update value and frequency
        if (nodeMap.containsKey(key)) {
            Node node = nodeMap.get(key);
            node.value = value;
            updateFrequency(node);
            return;
        }

        // If cache is full → evict LFU node
        if (nodeMap.size() == capacity) {
            DoublyLinkedList minFreqList = freqMap.get(minFreq);
            Node toRemove = minFreqList.removeLast();
            nodeMap.remove(toRemove.key);
        }

        // Insert new node with frequency = 1
        Node newNode = new Node(key, value);
        nodeMap.put(key, newNode);
        freqMap
            .computeIfAbsent(1, k -> new DoublyLinkedList())
            .addToHead(newNode);

        minFreq = 1; // reset min frequency
    }

    /* -------- UPDATE FREQUENCY OF A NODE -------- */
    private void updateFrequency(Node node) {
        int freq = node.freq;

        // Remove node from current frequency list
        DoublyLinkedList oldList = freqMap.get(freq);
        oldList.remove(node);

        // If this was the only node with minFreq, increase minFreq
        if (freq == minFreq && oldList.size == 0) {
            minFreq++;
        }

        // Move node to next frequency list
        node.freq++;
        freqMap
            .computeIfAbsent(node.freq, k -> new DoublyLinkedList())
            .addToHead(node);
    }
}
