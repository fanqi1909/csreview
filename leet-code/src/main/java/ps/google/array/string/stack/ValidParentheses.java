package ps.google.array.string.stack;

import java.util.Deque;
import java.util.LinkedList;

public class ValidParentheses {

    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();
        char[] map = new char[128];
        map[')'] = '(';
        map['}'] = '{';
        map[']'] = '[';

        for(char c : s.toCharArray()) {
            if(c == '(' || c == '{' || c== '[') {
                stack.push(c);
            } else {
                if(stack.isEmpty() || stack.peek() != map[c]) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParentheses solution = new ValidParentheses();
        System.out.println(solution.isValid("()"));
        System.out.println(solution.isValid("()[]"));
        System.out.println(solution.isValid("()[]{}"));
        System.out.println(!solution.isValid("()[]{}{"));
        System.out.println(solution.isValid("({}[()][]())"));
    }
}
