package org.jace.cs.review.lc.search.p39;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        dfs(results, new int[candidates.length], candidates, target, 0);
        return results;
    }

    private void dfs(List<List<Integer>> results, int[] coefficient, int[] candidates, int target, int i) {
        if(target == 0) {
            List<Integer> result = new ArrayList<>();
            for(int p = 0; p < candidates.length; p++) {
                for(int k = 1; k <= coefficient[p]; k++) {
                    result.add(candidates[p]);
                }
            }
            results.add(result);
        } else if( i < coefficient.length){
            for(int k = 0; k * candidates[i] <= target ; k++) {
                coefficient[i] = k;
                int remain = target - k * candidates[i];
                if(remain < 0) {
                    break;
                }
                dfs(results, coefficient, candidates,remain, i + 1 );
            }
            coefficient[i] = 0;
        }
    }
}
