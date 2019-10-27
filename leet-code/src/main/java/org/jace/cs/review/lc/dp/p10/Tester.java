package org.jace.cs.review.lc.dp.p10;

public class Tester {

    public static void main(String[] args) {
        Solution solution = new Solution();

        String test, pattern;

        test = "aaaaaa";
        pattern ="a*";
        System.out.printf("[%s] [%s] match = [%s]\n", test, pattern, solution.isMatch(test, pattern));


        test = "aab";
        pattern = "c*a*b";
        System.out.printf("[%s] [%s] match = [%s]\n", test, pattern, solution.isMatch(test, pattern));

        test = "mississippi";
        pattern = "mis*is*p*.";
        System.out.printf("[%s] [%s] match = [%s]\n", test, pattern, solution.isMatch(test, pattern));

        test = "";
        pattern = "a*b*";
        System.out.printf("[%s] [%s] match = [%s]\n", test, pattern, solution.isMatch(test, pattern));


        test = "abc";
        pattern = "";
        System.out.printf("[%s] [%s] match = [%s]\n", test, pattern, solution.isMatch(test, pattern));

        test = "ab";
        pattern = ".*";
        System.out.printf("[%s] [%s] match = [%s]\n", test, pattern, solution.isMatch(test, pattern));
    }
}
