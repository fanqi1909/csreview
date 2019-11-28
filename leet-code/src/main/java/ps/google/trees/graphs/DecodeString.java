package ps.google.trees.graphs;

import java.util.Deque;
import java.util.LinkedList;

public class DecodeString {

    public String decodeString(String s) {
        Deque<Character> cStack = new LinkedList<>();

        for(char c : s.toCharArray()) {
            if(c == ']') {
                StringBuilder buffer = new StringBuilder();
                //popping
                while(cStack.peek() != '[') {
                    buffer.append(cStack.pop());
                }
                cStack.pop();

                int base = 1;
                int occ = 0;
                while(!cStack.isEmpty() && Character.isDigit(cStack.peek())) {
                    occ += (cStack.pop() - '0') * base;
                    base = base * 10;
                }

                String token = buffer.reverse().toString();
                while(occ > 0) {
                    occ--;
                    for(char t : token.toCharArray()) {
                        cStack.push(t);
                    }
                }
            } else {
                cStack.push(c);
            }
        }
        char[] ans = new char[cStack.size()];
        for(int j = ans.length - 1; j >= 0; j--) {
            ans[j] = cStack.pop();
        }
        return new String(ans);
    }

    public static void main(String[] args) {
        DecodeString solution = new DecodeString();
        System.out.println(solution.decodeString("3[a]2[bc]") + "=== aaabcbc");
        System.out.println(solution.decodeString("abcd") + "=== abcd");
        System.out.println(solution.decodeString("3[a2[c]]") + "=== accaccacc");
        System.out.println(solution.decodeString("2[abc]3[cd]ef") + "=== abcabccdcdcdef");
        System.out.println(solution.decodeString("15[aa]") + "=== aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");


    }
}
