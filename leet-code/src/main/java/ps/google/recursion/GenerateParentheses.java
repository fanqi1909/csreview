package ps.google.recursion;

import java.util.*;

/**
 * Generate paratenthesis from smaller n. This leads to a dp solution:
 * <p>
 * dp[i] = forall k, "(" + dp[k] + ")" + dp[i - k - 1];
 */
public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {

        List<String>[] dp = new List[n + 1];

        dp[0] = Collections.singletonList("");
        dp[1] = Collections.singletonList("()");

        for (int i = 2; i <= n; i++) {
            dp[i] = new ArrayList<>();
            for (int k = 0; k < i; k++) {
                List<String> part1 = dp[k];
                List<String> part2 = dp[i - k - 1];
                for (String p1 : part1) {
                    for (String p2 : part2) {
                        dp[i].add("(" + p1 + ")" + p2);
                    }
                }
            }
        }
        return dp[n];
    }



    public static void main(String[] args) {
        GenerateParentheses gen = new GenerateParentheses();
        System.out.println(gen.generateParenthesis(1));
        System.out.println(gen.generateParenthesis(2));
        System.out.println(gen.generateParenthesis(3));
        System.out.println(gen.generateParenthesis(4));
    }

//    "(((())))"
//    "()((()))",
//    "((()))()",
//    "(()(()))",
//    "()()(())"
//    "()(())()"
//    "((())())"
//    "(())()()"
//    "()(()())"
//    "(()()())"
//    "()()()()"
//    ,"((()()))",,,,"(()())()","(())(())",,,,,
}
