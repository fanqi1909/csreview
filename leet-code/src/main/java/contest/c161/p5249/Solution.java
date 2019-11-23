package contest.c161.p5249;

public class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder backward = new StringBuilder();
        StringBuilder forward = new StringBuilder();
        int countOfParenthesis = 0;
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (current == '(') {
                countOfParenthesis++;
                forward.append(current);
            } else if (current == ')') {
                countOfParenthesis--;
                if (countOfParenthesis < 0) {
                    countOfParenthesis = 0;
                } else {
                    forward.append(current);
                }
            } else {
                forward.append(current);
            }
        }

        countOfParenthesis = 0;
        for (int i = forward.length() - 1; i >= 0; i--) {
            char current = forward.charAt(i);
            if (current == ')') {
                countOfParenthesis++;
                backward.insert(0, current);
            } else if (current == '(') {
                countOfParenthesis--;
                if (countOfParenthesis < 0) {
                    countOfParenthesis = 0;
                } else {
                    backward.insert(0, current);
                }
            } else {
                backward.insert(0, current);
            }
        }

        return backward.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minRemoveToMakeValid("lee(t(c)o)de)"));
        System.out.println(solution.minRemoveToMakeValid("a)b(c)d"));
        System.out.println(solution.minRemoveToMakeValid("))(("));
        System.out.println(solution.minRemoveToMakeValid("(a(b(c)d)"));

    }
}