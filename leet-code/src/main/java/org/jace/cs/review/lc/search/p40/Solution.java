package org.jace.cs.review.lc.search.p40;

import java.util.*;

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> results = new LinkedList<>();

        Map<Integer, Integer> histogram = new HashMap<>();

        for (int candidate : candidates) {
            histogram.put(candidate, histogram.getOrDefault(candidate, 0) + 1);
        }

        int[] newCandidates = new int[histogram.size()];
        int[] inventories = new int[histogram.size()];
        int i = 0;
        for(Map.Entry<Integer, Integer> entry : histogram.entrySet()) {
            newCandidates[i] = entry.getKey();
            inventories[i] = entry.getValue();
            i++;
        }

        dfs(results, newCandidates, inventories, new int[histogram.size()], target, 0);
        return results;
    }

    private void dfs(List<List<Integer>> results, int[] candidates, int[] inventories, int[] coefficient, int target, int i) {
        if(target == 0) {
            List<Integer> result = new ArrayList<>();
            for(int p = 0; p < candidates.length; p++) {
                for(int k = 1; k <= coefficient[p]; k++) {
                    result.add(candidates[p]);
                }
            }
            results.add(result);
        } else if( i < coefficient.length){
            for(int k = 0; k <= inventories[i] && k * candidates[i] <= target ; k++) {
                coefficient[i] = k;
                int remain = target - k * candidates[i];
                if(remain < 0) {
                    break;
                }
                dfs(results, candidates, inventories, coefficient, remain, i + 1 );
            }
            coefficient[i] = 0;
        }
    }
}