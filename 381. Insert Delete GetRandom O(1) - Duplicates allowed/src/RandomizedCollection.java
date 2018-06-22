import java.util.*;

class RandomizedCollection {
    Map<Integer, Set<Integer>> map; // use a Set to store index intead of list.
    ArrayList<Integer> list;
    Random random = new Random();
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean contain = map.containsKey(val);
        int len = list.size();
        if(!contain) {
            Set<Integer> subset = new HashSet<>();
            subset.add(len);
            map.put(val, subset);
        }
        else{
            map.get(val).add(len);
        }
        list.add(val);
        return !contain;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        boolean contain = map.containsKey(val);
        if (! contain) return false;
        int len = list.size();
        Iterator<Integer> itor = map.get(val).iterator(); // use Iterator to get a element in a HashSet. Specify the type of Iterator.
        int idx = itor.next();
        if(map.get(val).size() == 1) map.remove(val); // remove the index of val in the map first.
        else map.get(val).remove(idx);
        if(idx != len - 1){ //**********Key node : swap the last element in the ArrayList with the value we are going to remove.
            int lastone = list.get(len - 1);
            list.set(idx, lastone);
            map.get(lastone).add(idx);
            map.get(lastone).remove(len - 1);
        }
        list.remove(len - 1);
        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        int i = random.nextInt(list.size());
        return list.get(i);
    }

    public static void main ( String[] args) {
        RandomizedCollection collection = new RandomizedCollection();
        collection.insert(4);
        collection.insert(3);
        collection.insert(4);
        collection.insert(2);
        collection.insert(4);
        collection.remove(4);
        collection.remove(3);
        collection.remove(4);
        collection.remove(4);
        collection.getRandom();
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */