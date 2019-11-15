package org.jace.cs.review.lc.search.p93;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new LinkedList<>();
        dfs(0, 3, s, new StringBuilder(), result);
        return result;
    }


    private void dfs(int position, int remainDots, String s, StringBuilder current, List<String> result) {
        if (position >= s.length()) {
            //start from 0
            return;
        }
        if (remainDots == 0) {
            String part = s.substring(position);
            if (isValidIPNumber(part)) {
                result.add(current.toString() + part);
            }
        } else {
            for (int i = 1; position + i < s.length(); i++) {
                String part = s.substring(position, position + i);
                if (isValidIPNumber(part)) {
                    dfs(position + i, remainDots - 1, s, current.append(part).append("."), result);
                    current.delete(current.length() - part.length() - 1, current.length());
                } else {
                    break;
                }
            }
        }
    }

    private boolean isValidIPNumber(String part) {
        int len = part.length();
        if(len <= 0) {
            return false;
        } else if(len == 1) {
            return part.charAt(0) >= '0' && part.charAt(0) <= '9';
        } else if(len < 4) {
            return part.charAt(0) != '0' && Integer.parseInt(part) <= 255;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.restoreIpAddresses("25525511135").forEach(System.out::println);

        solution.restoreIpAddresses("25512211135").forEach(System.out::println);

        solution.restoreIpAddresses("2550211135").forEach(System.out::println);

        solution.restoreIpAddresses("0000").forEach(System.out::println);

        solution.restoreIpAddresses("010010").forEach(System.out::println);
    }
}
