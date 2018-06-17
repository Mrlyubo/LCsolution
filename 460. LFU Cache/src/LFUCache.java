
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class LFUCache {
    class Keytime implements Comparable<Keytime> {
        int key;
        long frq;
        long timeCnt;
        public Keytime(int k, long frq, long timeCnt) {
            this.key = k;
            this.frq = frq;// *** note: do not miss this.
            this.timeCnt = timeCnt;
        }
        @Override
        public int compareTo(Keytime o) {
            if(this.frq  !=  o.frq)
                return (int) (this.frq - o.frq);
            else
                return (int) (this.timeCnt - o.timeCnt);
        }
    }

    int capacity;
    long timeCnt = 0;
    HashMap<Integer, Long> frqmap = new HashMap<>();   //Map  <key, frequency>;
    HashMap<Integer, Long> timemap = new HashMap<>();  //Map  <key, timeCount>;
    TreeMap<Keytime, Integer> caches = new TreeMap<>();//TreeMap <Keytime <key,frq,timeCnt>, Value>

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!frqmap.containsKey(key))
            return -1;
        else {
            // get the result via key.
            long oldfrq = frqmap.get(key).longValue();
            Keytime kt = new Keytime(key, oldfrq, timemap.get(key).longValue());
            int res = caches.get(kt);

            //update the map and the caches.
            long newtime = timeCnt++;
            frqmap.put(key, oldfrq+1);
            timemap.put(key, newtime);
            Keytime newKeytime = new Keytime(key, oldfrq+1,newtime);
            caches.remove(kt);//get() method will not increase the size of caches,cuz it perform "remove" and "put" every time we call get().
            caches.put(newKeytime, res);
            return res;
        }
    }

    public void put(int key, int value) {
        long newtime = timeCnt++;
        long oldfrq = frqmap.getOrDefault(key,(long)0);
        if (frqmap.containsKey(key)) {
            long oldtime = timemap.get(key);
            frqmap.put(key,oldfrq+1);
            timemap.put(key, newtime);
            caches.remove(new Keytime(key,oldfrq, oldtime));
            caches.put(new Keytime(key, oldfrq+1,newtime), value);
        } else if (frqmap.size() < capacity) {
            timemap.put(key, newtime);
            frqmap.put(key,oldfrq+1);
            caches.put(new Keytime(key,oldfrq+1,newtime), value);
        } else {
            if(caches.size() != 0){
                Map.Entry<Keytime, Integer> headentry = caches.pollFirstEntry();
                int headkey = headentry.getKey().key;
                frqmap.remove(headkey);
                timemap.remove(headkey);
                frqmap.put(key, oldfrq+1);
                timemap.put(key, newtime);
                caches.put(new Keytime(key, oldfrq+1,newtime), value);
            }
            else return;
        }
    }


    public static void main(String[] args) {
        /*LFUCache cache = new LFUCache( 2 *//* capacity *//*);
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

        LFUCache cache1 = new LFUCache( 0 *//* capacity *//* );
        cache1.put(0, 0);
        System.out.println("-1:"+cache1.get(0)); */      // returns- 1

        LFUCache cache2 = new LFUCache( 2 /* capacity */ );
        cache2.put(2, 1);
        cache2.put(2, 2);
        System.out.println("2:"+cache2.get(2));
        cache2.put(1, 1);
        cache2.put(4, 1);
        System.out.println("2:"+cache2.get(2));
    }
}


