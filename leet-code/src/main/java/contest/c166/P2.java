package contest.c166;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class P2 {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<Integer>> allocations = new HashMap<>();
        for(int i = 0; i < groupSizes.length; i++) {
            allocations.computeIfAbsent(groupSizes[i], k -> new LinkedList<>()).add(i);
        }
        List<List<Integer>> ans = new LinkedList<>();
        for(Map.Entry<Integer, List<Integer>> allocation : allocations.entrySet()) {
            List<Integer> ids = allocation.getValue();
            Integer size = allocation.getKey();
            List<Integer> an;
            while(ids.size() > 0) {
                an = new LinkedList<>();
                while (an.size() < size) {
                    an.add(ids.remove(0));
                }
                ans.add(an);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        P2 solution = new P2();

        System.out.println(solution.groupThePeople(new int[]{3,3,3,3,3,1,3}));
        System.out.println(solution.groupThePeople(new int[]{2,1,3,3,3,2}));
    }
}
