package ps.google.array.string;

import java.util.LinkedList;
import java.util.List;

public class MissingRange {
    public List<String> findMissingRanges(int[] nums2, int lower, int upper) {
        long[] nums = new long[nums2.length];
        for(int i = 0; i < nums2.length; i++) {
            nums[i] = (long)nums2[i];
        }

        List<String> result = new LinkedList<>();

        // an index i such that nums[i] < lower =< nums[i+1]
        // an index j such that nums[j - 1] <= upper < nums[j];
        int i = findLow(nums, lower);
        int j = findHigh(nums, upper);

        System.out.println(i + "\t" + j);
        if (i == nums.length - 1 || j == 0) {
            result.add(addRange(lower, upper));
            return result;
        }

        if (nums[i + 1] != lower) {
            result.add(addRange(lower, nums[i + 1] - 1));
        }


        for (int s = i + 2; s <= j - 1; s++) {
            if (nums[s] - nums[s - 1] >= 2) {
                result.add(addRange(nums[s - 1] + 1, nums[s] - 1));
            }
        }

        if (nums[j - 1] != upper) {
            result.add(addRange(nums[j - 1] + 1, upper));
        }

        return result;
    }

    private int findHigh(long[] nums, int upper) {
        int l = 0;
        int r = nums.length;
        while (l < r) {
            int m = (l + r) >>> 1;
            if (nums[m] <= upper) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }

    private int findLow(long[] nums, int low) {
        int l = -1;
        int r = nums.length - 1;
        while (l < r) {
            int m = (l + r + 1) >>> 1;
            if (nums[m] >= low) {
                r = m - 1;
            } else {
                l = m;
            }
        }
        return l;
    }


    private String addRange(long n1, long n2) {
        if (n1 == n2) {
            return n1 + "";
        } else {
            return n1 + "->" + n2;
        }
    }

    public static void main(String[] args) {
        MissingRange solution = new MissingRange();
        System.out.println(solution.findMissingRanges(new int[]{}, 2, 99));
        System.out.println(solution.findMissingRanges(new int[]{}, 1, 1));
        System.out.println(solution.findMissingRanges(new int[]{0, 1, 3, 50, 75}, 2, 99));
        System.out.println(solution.findMissingRanges(new int[]{0, 1, 3, 50, 75}, 0, 99));

        System.out.println(solution.findMissingRanges(new int[]{0, 1, 3, 50, 75}, 2, 49));

        System.out.println(solution.findMissingRanges(new int[]{0, 1, 3, 50, 75}, 2, 75));
        System.out.println(solution.findMissingRanges(new int[]{0, 1}, 0, 1));
        System.out.println(solution.findMissingRanges(new int[]{1, 1, 1}, 1, 1));
        System.out.println(solution.findMissingRanges(new int[]{-2147483648, 2147483647}, -2147483648, 2147483647));
        System.out.println(solution.findMissingRanges(new int[]{0,1,3,50,75}, 0, 99));


    }
}
