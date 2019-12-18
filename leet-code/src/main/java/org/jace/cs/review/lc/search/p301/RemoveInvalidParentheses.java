package org.jace.cs.review.lc.search.p301;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveInvalidParentheses {

    public List<String> removeInvalidParentheses(String s) {
        Set<String> ans = new HashSet<>();

        int[] toBeDeleted = misPlaced(s);

        dfs(0, toBeDeleted[0], toBeDeleted[1], 0, new StringBuilder(), s.toCharArray(), ans);

        return new ArrayList<>(ans);
    }

    private void dfs(int start, int leftRemain, int rightRemain, int open, StringBuilder result, char[] s, Set<String> ans) {
        if (leftRemain < 0 || rightRemain < 0 || open < 0) return;
        if (start == s.length) {
            if(open == 0) {
                ans.add(result.toString());
            }
        } else {
            char c = s[start];
            if (c == '(') {
                dfs(start + 1, leftRemain - 1, rightRemain, open, result, s, ans); // remove current '('
                result.append('(');
                dfs(start + 1, leftRemain, rightRemain, open + 1, result, s, ans); // retain the current '('
                result.deleteCharAt(result.length() - 1);

            } else if (c == ')') {
                dfs(start + 1, leftRemain, rightRemain - 1, open, result, s, ans); // remove the current ')'
                result.append(')');
                dfs(start + 1, leftRemain, rightRemain, open - 1, result, s, ans); // remove the current ')'
                result.deleteCharAt(result.length() - 1);
            } else {
                result.append(c);
                dfs(start + 1, leftRemain, rightRemain, open, result, s, ans);
                result.deleteCharAt(result.length() - 1);
            }
        }
    }

    private int[] misPlaced(String s) {
        int lc = 0;
        int rc = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                lc++;
            } else if (s.charAt(i) == ')') {
                rc++;
                lc--;
                if (lc < 0) {
                    lc = 0;
                }
            }
        }
        return new int[]{lc, rc};
    }

    public static void main(String[] args) {
        RemoveInvalidParentheses removeInvalidParentheses = new RemoveInvalidParentheses();
        System.out.println(removeInvalidParentheses.removeInvalidParentheses("lee(t(c)o)de)"));
        System.out.println(removeInvalidParentheses.removeInvalidParentheses("a)b(c)d"));
        System.out.println(removeInvalidParentheses.removeInvalidParentheses("))(("));
        System.out.println(removeInvalidParentheses.removeInvalidParentheses("(a(b(c)d)"));

        System.out.println(removeInvalidParentheses.removeInvalidParentheses("()())()"));

        System.out.println(removeInvalidParentheses.removeInvalidParentheses("(a)())()"));

        System.out.println(removeInvalidParentheses.removeInvalidParentheses(")("));
    }
}
