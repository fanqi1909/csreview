package org.jace.cs.review.lc.search.p332;

import java.util.*;

public class ReconstructItinerary {

    public List<String> findItinerary(List<List<String>> tickets) {
        LinkedList<String> res = new LinkedList<>();
        if (tickets == null || tickets.size() == 0) return res;
        Map<String, List<String>> map = new HashMap<>();
        for (List<String> ticket : tickets) {
            map.computeIfAbsent(ticket.get(0), k -> new ArrayList<>()).add(ticket.get(1));
        }
        for (List<String> value : map.values()) {
            value.sort(Comparator.reverseOrder());
        }

        //post-order traverse of the graph
        dfs(res, "JFK", map);
        return res;
    }

    private void dfs(List<String> res, String cur, Map<String, List<String>> map) {
        if (map.containsKey(cur)) {
            List<String> children = map.get(cur);
            while (children.size() > 0) {
                String child = children.remove(children.size() - 1);
                dfs(res, child, map);
            }
        }
        res.add(0, cur);
    }

    public static void main(String[] args) {
        ReconstructItinerary ri = new ReconstructItinerary();

        System.out.println(ri.findItinerary(
                Arrays.asList(
                        Arrays.asList("MUC", "LHR"),
                        Arrays.asList("JFK", "MUC"),
                        Arrays.asList("SFO", "SJC"),
                        Arrays.asList("LHR", "SFO")
                )
        ));

        System.out.println(ri.findItinerary(
                Arrays.asList(
                        Arrays.asList("JFK", "SFO"),
                        Arrays.asList("JFK", "ATL"),
                        Arrays.asList("SFO", "ATL"),
                        Arrays.asList("ATL", "JFK"),
                        Arrays.asList("ATL", "SFO")
                )
        ));

        System.out.println(ri.findItinerary(
                Arrays.asList(
                        Arrays.asList("JFK", "KUL"),
                        Arrays.asList("JFK", "NRT"),
                        Arrays.asList("NRT", "JFK")
                )
        ));
    }

}
