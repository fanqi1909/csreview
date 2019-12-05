package ps.google.design;

import java.util.*;

public class RandomizedSet {

    int nextPosition;
    List<Integer> data;
    Map<Integer, Integer> lookup;
    Random random;

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
        nextPosition = 0;
        data = new LinkedList<>();
        lookup = new HashMap<>();
        random = new Random();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (lookup.containsKey(val)) {
            return false;
        }
        if (nextPosition >= data.size()) {
            data.add(val);
        } else {
            data.set(nextPosition, val);
        }
        lookup.put(val, nextPosition);
        nextPosition++;
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if(lookup.containsKey(val)) {
            //swap the value with nextPosition - 1;
            int lastVal = data.get(nextPosition - 1);
            int valPosition = lookup.get(val);
            //swap
            data.set(valPosition, lastVal);
            data.set(nextPosition - 1, val);
            //update lookup
            lookup.put(lastVal, valPosition);
            lookup.remove(val);
            nextPosition--;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        int index = random.nextInt(nextPosition);
        return data.get(index);
    }

    public static void main(String[] args) {
        RandomizedSet rset = new RandomizedSet();

        System.out.println(rset.insert(1));
        System.out.println(rset.remove(2));

        System.out.println(rset.insert(2));
        System.out.println(rset.getRandom());
        System.out.println(rset.getRandom());
        System.out.println(rset.getRandom());
        System.out.println(rset.remove(1));
        System.out.println(rset.insert(2));

        System.out.println(rset.getRandom());
        System.out.println(rset.getRandom());
        System.out.println(rset.getRandom());


    }
}
