import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class LRUCache {
    private int size;
    private int capacity;
    private List<Integer> keyList = new LinkedList<>();
    private Map<Integer, Integer> map = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
    }

    public int get(int key) {
        if(keyList.contains(key)){
            keyList.remove(keyList.indexOf(key));
            keyList.add(0,key);
            return map.get(key);

        }
        else
            return -1;
    }

    public void put(int key, int value) {
        if(!keyList.contains(key)){
            if(size != capacity ){
                keyList.add(0,key);
                size++;
            }
            else if( size == capacity ){
                keyList.remove(capacity-1);
                keyList.add(0,key);
            }
        }
        else {
            keyList.remove(keyList.indexOf(key));
            keyList.add(0,key);
        }
        map.put(key,value);
    }

    public static void main (String[] args){ // Can not miss static ;
        LRUCache cache = new LRUCache( 2 );
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println("1："+cache.get(1));       // returns 1
        cache.put(3, 3);                        // evicts key 2
        System.out.println("-1："+cache.get(2));       // returns -1 (not found)
        cache.put(4, 4);                        // evicts key 1
        System.out.println("-1："+cache.get(1));       // returns -1 (not found)
        System.out.println("3："+cache.get(3));       // returns 3
        System.out.println("4："+cache.get(4));       // returns 4

        LRUCache cache1 = new LRUCache(2);
        System.out.println("-1:"+cache1.get(2));
        cache1.put(2,6);
        System.out.println("-1:"+cache1.get(1));
        cache1.put(1,5);
        cache1.put(1,2);
        System.out.println("2:"+cache1.get(1));
        System.out.println("6:"+cache1.get(2));

    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */