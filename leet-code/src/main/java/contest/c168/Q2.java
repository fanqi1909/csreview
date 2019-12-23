package contest.c168;

import java.util.TreeMap;

public class Q2 {

    public boolean isPossibleDivide(int[] nums, int k) {
        TreeMap<Integer, Integer> occ = new TreeMap<>();
        for(int num : nums) {
            occ.put(num, occ.getOrDefault(num, 0) + 1);
        }

        while(!occ.isEmpty()) {
            int delta = k ;
            int start = occ.firstKey();
            while(delta > 0 && !occ.isEmpty()) {
                if(!occ.containsKey(start)) {
                    break;
                }
                if(occ.get(start) == 1) {
                    occ.remove(start);
                } else {
                    occ.put(start, occ.get(start) - 1);
                }
                delta--;
                start++;
            }
            if(delta != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Q2 sol = new Q2();
        System.out.println(sol.isPossibleDivide(new int[]{1,2,3,3,4,4,5,6}, 4));
        System.out.println(sol.isPossibleDivide(new int[]{3,2,1,2,3,4,3,4,5,9,10,11}, 3));
        System.out.println(sol.isPossibleDivide(new int[]{3,3,2,2,1,1}, 3));
        System.out.println(sol.isPossibleDivide(new int[]{1,2,3,4}, 3));
        System.out.println(sol.isPossibleDivide(new int[]{15,16,17,18,19,16,17,18,19,20,6,7,8,9,10,3,4,5,6,20}, 5));
    }
}
