package ps.google.array.string.mono.stack;

import java.util.*;

/**
 *  need to keep finding odd/even jumps from A[i..n], for all ranges.
 *  the trick is to build a BST for the range A[1,n], and remove element from it after scanning
 */
public class OddEvenJump {
    public int oddEvenJumps(int[] A) {
        Set<Integer>[][] map = new Set[A.length][2];

        TreeMap<Integer, List<Integer>> occurs = new TreeMap<>();

        for (int i = 0; i < A.length; i++) {
            if (map[i][0] == null) map[i][0] = new HashSet<>();
            if (map[i][1] == null) {
                map[i][1] = new HashSet<>();
                map[i][1].add(i);
            }
            if(!occurs.containsKey(A[i])) {
                occurs.put(A[i], new LinkedList<>());
            }
            occurs.get(A[i]).add(i);
        }

        for (int i = 0; i < A.length; i++) {
            List<Integer> occ = occurs.get(A[i]);
            occ.remove(0);
            if(occ.isEmpty()) {
                occurs.remove(A[i]);
            }
            //perform odd jump;
            int oddIndexes = moveOdd(A[i], occurs);
                    //moveOdd(i, A);
            if (oddIndexes != -1) {
                map[oddIndexes][0].addAll(map[i][1]);
            }

            int evenIndexes = moveEven(A[i], occurs);
            //moveEven(i, A);
            if (evenIndexes != -1) {
                map[evenIndexes][1].addAll(map[i][0]);
            }
        }

        Set<Integer> arriveAtOdd = map[A.length - 1][0];
        Set<Integer> arriveAtEven = map[A.length - 1][1];
        Set<Integer> result = new HashSet<>();
        result.addAll(arriveAtEven);
        result.addAll(arriveAtOdd);
//        System.out.println(result);
        return result.size();
    }

    private int moveEven(int a, TreeMap<Integer, List<Integer>> occ) {
        Map.Entry<Integer, List<Integer>> positions = occ.floorEntry(a);
        if(positions == null) {
            return -1;
        } else {
            List<Integer> pos = positions.getValue();
            return pos.get(0);
        }
    }

    private int moveOdd(int a, TreeMap<Integer, List<Integer>> occ) {
        Map.Entry<Integer, List<Integer>> positions = occ.ceilingEntry(a);
        if(positions == null) {
            return -1;
        } else {
            List<Integer> pos = positions.getValue();
            return pos.get(0);
        }
    }

    public static void main(String[] args) {
        OddEvenJump solution = new OddEvenJump();
        System.out.println(solution.oddEvenJumps(new int[]{10, 13, 12, 14, 15}));
        System.out.println(solution.oddEvenJumps(new int[]{2, 3, 1, 1, 4}));
        System.out.println(solution.oddEvenJumps(new int[]{5, 1, 3, 4, 2}));
    }

    private int moveEven(int i, int[] a) {
        int max = 0, index = -1;
        for (int j = i + 1; j < a.length; j++) {
            if (a[j] > max && a[j] <= a[i]) {
                max = a[j];
                index = j;
            }
        }
        return index;
    }

    private int moveOdd(int i, int[] a) {
        int min =100001, index = -1;
        for (int j = i + 1; j < a.length; j++) {
            if (a[j] < min && a[j] >= a[i]) {
                min = a[j];
                index = j;
            }
        }
        return index;
    }

}
