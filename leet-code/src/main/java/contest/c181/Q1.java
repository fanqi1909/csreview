package contest.c181;

import java.util.ArrayList;
import java.util.List;

public class Q1 {

    public int[] createTargetArray(int[] nums, int[] indexes) {

        List<Integer> ans = new ArrayList<>(nums.length);
        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int index = indexes[i];
            ans.add(index ,num);
        }
        int[] res = new int[nums.length];
        int p = 0;
        for(Integer i : ans) {
            res[p++] = i;
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
