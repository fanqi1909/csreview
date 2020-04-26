package contest.c173;

import java.util.*;

public class Q4 {

    public String largestMultipleOfThree(int[] digits) {

        List<Integer>[] ms = new List[3];
        for (int i = 0; i < 3; i++) {
            ms[i] = new ArrayList<>();
        }

        int totalR = 0;
        for (int digit : digits) {
            ms[digit % 3].add(digit);
            totalR += digit;
        }
        totalR = totalR % 3;

        List<Integer> qualified = new ArrayList<>(ms[0]);

        ms[1].sort((a, b) -> b - a);
        ms[2].sort((a, b) -> b - a);

        if (totalR == 2) {
            if (!ms[2].isEmpty()) {
                ms[2].remove(ms[2].size() - 1);
            } else {
                ms[1].remove(ms[1].size() - 1);
                ms[1].remove(ms[1].size() - 1);
            }
        } else if(totalR == 1) {
            // == 1
            if (!ms[1].isEmpty()) {
                ms[1].remove(ms[1].size() - 1);
            } else {
                ms[2].remove(ms[2].size() - 1);
                ms[2].remove(ms[2].size() - 1);
            }
        }

        qualified.addAll(ms[1]);
        qualified.addAll(ms[2]);

        qualified.sort((a, b) -> b - a);

        StringBuilder ans = new StringBuilder();
        for(int i : qualified) {
            ans.append(i);
            if(ans.charAt(0) == '0') {
                return ans.toString();
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        Q4 q4 = new Q4();
        System.out.println(q4.largestMultipleOfThree(new int[]{8, 1, 9}));
        System.out.println(q4.largestMultipleOfThree(new int[]{8,6,7,1,0}));
        System.out.println(q4.largestMultipleOfThree(new int[]{1}));
        System.out.println(q4.largestMultipleOfThree(new int[]{0,0,0,0,0,0}));
    }
}
