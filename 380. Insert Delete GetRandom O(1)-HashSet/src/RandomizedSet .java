import java.util.*;
class RandomizedSet {
    private Set<Integer> data;
    java.util.Random rand = new java.util.Random();

    /** Initialize your data structure here. */
    public RandomizedSet() {
        data = new HashSet<Integer>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (data.contains(val))
            return false;
        data.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!data.contains(val))
            return false;
        data.remove(val);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int index = rand.nextInt(data.size());
        Integer[] dt = data.toArray(new Integer[data.size()]);
        return dt[index];
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

