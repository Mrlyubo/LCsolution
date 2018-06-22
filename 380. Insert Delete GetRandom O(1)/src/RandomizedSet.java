import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class RandomizedSet {
    /***********Intuition: two Array.
     * 1. Use an boolean[] exist:  index of exist = insert_val; if exist, exist[index] = True;
     * 2. Use an int[] map: index of map = size;  map[index] = index of exist[].
     * 3. Problem: when we insert a very large number, the size of boolean[] will be very large too.
     * 4. resize it.
     ***********New Idea:
     * 1. HashMap and ArrayList.(get will be fast, it will not have the size problem)
     * 2. We can use a HashMap to implement a Set, it is kind of treating. However, it is allowed.
     * 3. ArrayList<size><value>:
     *    0  1
     *    1  2
     * 4. HashMap<Value, Index>;
     * 5. Problem: remove the item in the ArrayList will cause the changes in every item in the ArrayList.
     * 6. To solve this problem, we can  swap the last one with val value we are going to remove. And remove the last one in the ArrayList.
     * *********Follow Up: the duplicated number is allowed.
     * Answer: Use a map that has a list as the value. Map<KeyType, List<ValueType>>.
     * */

    /** Initialize your data structure here. */

    ArrayList<Integer> nums;
    HashMap<Integer, Integer> locs;
    java.util.Random rand = new java.util.Random();
    /** Initialize your data structure here. */
    public RandomizedSet() {
        nums = new ArrayList<Integer>();
        locs = new HashMap<Integer, Integer>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        boolean contain = locs.containsKey(val);
        if ( contain ) return false;
        locs.put( val, nums.size());
        nums.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        boolean contain = locs.containsKey(val);
        if ( ! contain ) return false;
        int loc = locs.get(val);
        if (loc < nums.size() - 1 ) { // not the last one than swap the last one with this val
            int lastone = nums.get(nums.size() - 1 );
            nums.set( loc , lastone );
            locs.put(lastone, loc);
        }
        locs.remove(val);
        nums.remove(nums.size() - 1);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return nums.get( rand.nextInt(nums.size()) );
    }

    public static void main(String[] args) {
        // Init an empty set.
        RandomizedSet randomSet = new RandomizedSet();

        // Inserts 4 to the set. Returns true as 4 was inserted successfully.
        randomSet.insert(4);

        // Returns false as 5 does not exist in the set.
        randomSet.remove(5);

        // Inserts 6 to the set, returns true. Set now contains [4,6].
        randomSet.insert(6);

        // getRandom should return either 4 or 6 randomly.
        randomSet.getRandom();

        // Removes 4 from the set, returns true. Set now contains [6].
        randomSet.remove(4);

        // 6 was already in the set, so return false.
        randomSet.insert(6);

        // Since 4 is the only number in the set, getRandom always return 6.
        randomSet.getRandom();
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */

