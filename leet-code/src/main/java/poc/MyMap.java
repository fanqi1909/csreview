package poc;

import java.util.HashMap;
import java.util.Map;

public class MyMap {

    private Map<Integer, Integer> actualMap;

    private int keyOffset;
    private int valOffset;

    public MyMap() {
        actualMap = new HashMap<>();
        keyOffset = 0;
        valOffset = 0;
    }

    public void incKey(int inc) {
        keyOffset += inc;
    }

    public void incVal(int inc) {
        valOffset += inc;
    }

    public void put(int k, int v) {
        actualMap.put(k - keyOffset, v - valOffset);
    }

    public int get(int k) {
        return actualMap.get(k - keyOffset) + valOffset;
    }

    public static void main(String[] args) {
        MyMap m = new MyMap();

        m.put(1, 1);
        m.put(2, 2);
        m.put(3, 3);

        System.out.println(m.get(1));
        System.out.println(m.get(2));
        System.out.println(m.get(3));

        m.incKey(1);
        System.out.println(m.get(2));
        System.out.println(m.get(3));
        System.out.println(m.get(4));

        m.put(5, 5);
        m.put(6, 6);
        m.put(7, 7);
        System.out.println(m.get(5));
        System.out.println(m.get(6));
        System.out.println(m.get(7));
        m.incKey(-1);
        System.out.println(m.get(1));
        System.out.println(m.get(2));
        System.out.println(m.get(3));
        System.out.println(m.get(4));
        System.out.println(m.get(5));
        System.out.println(m.get(6));


//
//        m.incVal(3);
//        System.out.println(m.get(1));
//        System.out.println(m.get(2));
//        System.out.println(m.get(3));
//
//        m.incVal(-2);
//        System.out.println(m.get(1));
//        System.out.println(m.get(2));
//        System.out.println(m.get(3));
//
//        m.put(4, 4);
//        m.put(5, 5);
//        m.put(6, 6);
//        System.out.println(m.get(4));
//        System.out.println(m.get(5));
//        System.out.println(m.get(6));
//
//        m.incVal(5);
//        System.out.println(m.get(1));
//        System.out.println(m.get(2));
//        System.out.println(m.get(3));
//        System.out.println(m.get(4));
//        System.out.println(m.get(5));
//        System.out.println(m.get(6));

    }
}
