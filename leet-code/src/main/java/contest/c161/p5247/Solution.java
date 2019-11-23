package contest.c161.p5247;


/**
 * 1247. Minimum Swaps to Make Strings Equal
 * <p>
 * You are given two strings s1 and s2 of equal length consisting of letters "x" and "y" only.
 * Your task is to make these two strings equal to each other.
 * You can swap any two characters that belong to different strings, which means: swap s1[i] and s2[j].
 * <p>
 * Return the minimum number of swaps required to make s1 and s2 equal, or return -1 if it is impossible to do so.
 * <p>
 * Example 1:
 * <p>
 * Input: s1 = "xx", s2 = "yy"
 * Output: 1
 * Explanation:
 * Swap s1[0] and s2[1], s1 = "yx", s2 = "yx".
 * Example 2:
 * <p>
 * Input: s1 = "xy", s2 = "yx"
 * Output: 2
 * Explanation:
 * Swap s1[0] and s2[0], s1 = "yy", s2 = "xx".
 * Swap s1[0] and s2[1], s1 = "xy", s2 = "xy".
 * Note that you can't swap s1[0] and s1[1] to make s1 equal to "yx", cause we can only swap MaxDistanceToClosestPerson in different strings.
 * Example 3:
 * <p>
 * Input: s1 = "xx", s2 = "xy"
 * Output: -1
 * Example 4:
 * <p>
 * Input: s1 = "xxyyxyxyxx", s2 = "xyyxyxxxyx"
 * Output: 4
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s1.length, s2.length <= 1000
 * s1, s2 only contain 'x' or 'y'.
 */

/**
 * A few sub-problems needs to be considered for this problem. Start with simple ones.
 * <p>
 * 1. If we have two arrays A and B with equal even size: A is only with 'x', B is only with 'y', how many swaps are required to make A, B identical ?
 *    The answer is |A|/2 + |B|/2 as follows:
 *    Let's split A into half, A1 and A2. Split B into half, B1 and B2. Since A, B are of equal size, we swap the subarray A1 and B2 (or A2 and B1).
 *        E.g., A: A1 : A2,
 *              B: B1 : B2
 *       then, after swap, we have A1:B2 and A2:B1, they are identical.
 * <p>
 * 2. Given an array A with mixed 'x' and 'y', if B is an opposite array of A, i.e., if A[i] != B[i] for all i, how many swaps are required?
 *    We can divide A into two subsequences, one with only 'x' and another with only 'y'. By doing so, B can be split in the same way, due to the constraint A[i] != B[i].
 *    Then, each subsequence would be a CASE-1 problem, we can add up the solution.
 *
 *    For example, let A be [x, x, y, y, x, y] and B be [y, y, x, x, y, x]
 *    The two subsqeuences generated from A is  X = [x, x, . , . , x, .] and  Y = [., ., y, y, ., y]
 *    The two subsequences generated from B is [y, y, . , . , y, .] and [., ., x, x, ., x]
 *
 *    So both the two subsequences pairs form a CASE-1 scenario.
 * <p>
 *      A few edge scenarios needs to be considered:
 *          1. if X (the subsequence of A only contains 'x') is odd, and Y is even, this result no solution
 *          2. if X is odd and Y is odd, we can pair the left-alone x and y, form a sequence ['x', 'y'], which requires two swaps to match
 *          3. if X is even and Y is odd, this is the same as 1.
 * <p>
 * 3. To turn the original problem to case-2, a simple transformation is required
 *    scan through s1 and s2, skip the position where s1[i] == s2[i].
 *    This ensures the resulting s1 and s2 matches the property of case 2, where s1[i] != s2[i] for all i.
 * <p>
 *
 * Notice that this question only requires the number of swaps. From above analysis, we only need to count number of X and Y in the reduced string s1.
 * But if we wish to print-out the swapping process, we can revert back to the CASE-2 implementation.
 *
 *
 * Optimality can be proved as follows: Let D be the differences between s1 and s2. D = count(s1[i] != s2[i]). The goal is to reduce D into 0.
 * Each swap would at most lead D to decrease by 2 (at most two positions are affected in s1). so at least D/2 swaps are required.
 * This is same as what we computed.
 */
public class Solution {
    public int minimumSwap(String s1, String s2) {
        if (s1.length() != s2.length()) return -1;
        int x1 = 0, y1 = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (s1.charAt(i) == 'x') {
                    x1++;
                } else {
                    y1++;
                }
            }
        } // transforming case 3 into case 2

        if (((x1 % 2) ^ (y1 % 2)) == 1) {
            return -1; // CASE 2.1 and 2.3
        }

        int swaps = x1 / 2 + y1 / 2;

        if (x1 % 2 == 1) {
            swaps += 2; // CASE 2.2
        }
        return swaps;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("1 === " + solution.minimumSwap("xx", "yy"));
        System.out.println("2 === " + solution.minimumSwap("xy", "yx"));
        System.out.println("-1 === " + solution.minimumSwap("xx", "yx"));
        System.out.println("4 === " + solution.minimumSwap("xxyyxyxyxx", "xyyxyxxxyx"));
        System.out.println("2 === " + solution.minimumSwap("xyxyy", "xxyyy"));
    }
}
