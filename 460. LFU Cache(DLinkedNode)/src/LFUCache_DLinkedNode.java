import java.util.*;

class LFUCache {
// Use my Approach, this way is too complicated.
    class DLinkedNode {
        int count;
        LinkedHashSet<Integer> keySet;
        DLinkedNode prior;
        DLinkedNode post;

        public DLinkedNode() {
            count = 0;
            keySet = new LinkedHashSet<>();
        }
    }

    private void insertAfter(DLinkedNode priorNode, DLinkedNode toInsertNode) {
        toInsertNode.prior = priorNode;
        toInsertNode.post = priorNode.post;
        priorNode.post.prior = toInsertNode;
        priorNode.post = toInsertNode;
    }

    private void removeNode(DLinkedNode toRemoveNode) {
        toRemoveNode.prior.post = toRemoveNode.post;
        toRemoveNode.post.prior = toRemoveNode.prior;
    }

    DLinkedNode head;
    DLinkedNode tail;
    int capacity;
    Map<Integer, DLinkedNode> idToNodeMap;
    Map<Integer, Integer> keyToValueMap;

    public LFUCache(int capacity) {
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.post = tail;
        tail.prior = head;
        this.capacity = capacity;
        idToNodeMap = new HashMap<>();
        keyToValueMap = new HashMap<>();
    }

    private void increaseCount(int key) {
        DLinkedNode node = idToNodeMap.get(key);
        node.keySet.remove(key);
        DLinkedNode currNode = null;
        if (node.post.count == node.count + 1) {
            currNode = node.post;
        } else {
            currNode = new DLinkedNode();
            currNode.count = node.count + 1;
            insertAfter(node, currNode);
        }
        idToNodeMap.put(key, currNode);
        currNode.keySet.add(key);
        if (node.keySet.size() == 0)
            removeNode(node);
    }

    public int get(int key) {
        if (!idToNodeMap.containsKey(key))
            return -1;
        increaseCount(key);
        return keyToValueMap.get(key);
    }

    public void put(int key, int value) {
        if (capacity == 0)
            return;
        if (keyToValueMap.containsKey(key)) {
            increaseCount(key);
            keyToValueMap.put(key, value);
            return;
        }
        if (keyToValueMap.size() == capacity) {
            int toRemoveKey = (int)head.post.keySet.iterator().next();
            head.post.keySet.remove(toRemoveKey);
            idToNodeMap.remove(toRemoveKey);
            keyToValueMap.remove(toRemoveKey);
            if (head.post.keySet.size() == 0) {
                removeNode(head.post);
            }
        }
        DLinkedNode node;
        if (head.post.count == 1) {
            node = head.post;
        } else {
            node = new DLinkedNode();
            node.count = 1;
            insertAfter(head, node);
        }
        node.keySet.add(key);
        keyToValueMap.put(key, value);
        idToNodeMap.put(key, node);
    }
    public static void main(String[] args) {
        LFUCache cache = new LFUCache( 2 /* capacity */);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println("1:"+cache.get(1));       // returns 1
        cache.put(3, 3);    // evicts key 2
        System.out.println("-1:"+cache.get(2));        // returns -1 (not found)
        System.out.println("3:"+cache.get(3));        // returns 3.
        cache.put(4, 4);    // evicts key 1.
        System.out.println("-1:"+cache.get(1));       // returns -1 (not found)
        System.out.println("3:"+cache.get(3));        // returns 3
        System.out.println("4:"+cache.get(4));        // returns 4

        LFUCache cache1 = new LFUCache( 0 /* capacity */ );
        cache1.put(0, 0);
        System.out.println("-1:"+cache1.get(0));       // returns- 1

        LFUCache cache2 = new LFUCache( 2 /* capacity */ );
        cache2.put(2, 1);
        cache2.put(2, 2);
        System.out.println("2:"+cache2.get(2));
        cache2.put(1, 1);
        cache2.put(4, 1);
        System.out.println("2:"+cache2.get(2));
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */