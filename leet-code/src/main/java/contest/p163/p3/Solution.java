package contest.p163.p3;

import java.util.*;

public class Solution {
    public int maxSumDivThree(int[] nums) {

        int sum = 0;
        Arrays.sort(nums);
        List<Integer> mod1 = new ArrayList<>();
        List<Integer> mod2 = new ArrayList<>();
        for (int num : nums) {
            sum += num;
            if (num % 3 == 1) mod1.add(num);
            if (num % 3 == 2) mod2.add(num);
        }
        int remainder = sum % 3;
        int best = 0;
        if (remainder == 1) {
            if (mod1.size() >= 1) {
                best = Math.max(best, sum - mod1.get(0));
            }
            if (mod2.size() >= 2) {
                best = Math.max(best, sum - mod2.get(0) - mod2.get(1));
            }
        } else if(remainder == 2) {
            if(mod1.size() >=2 ) {
                best = Math.max(best, sum - mod1.get(0) - mod1.get(1));
            }
            if(mod2.size() >=1) {
                best = Math.max(best, sum - mod2.get(0));
            }
        } else {
            best = sum;
        }
        return best;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.maxSumDivThree(new int[]{2, 6, 2, 2, 7}));

        System.out.println(solution.maxSumDivThree(new int[]{3, 6, 5, 1, 8}));
        System.out.println(solution.maxSumDivThree(new int[]{4}));
        System.out.println(solution.maxSumDivThree(new int[]{1, 2, 3, 4, 4, 4, 4, 4, 4}));
        System.out.println(solution.maxSumDivThree(new int[]{1, 2, 3, 4, 4}));
        System.out.println(solution.maxSumDivThree(new int[]{2, 19, 6, 16, 5, 10, 7, 4, 11, 6}));
    }
}
