package org.jace.cs.review.lc.string.p680;

import java.util.HashMap;
import java.util.Map;

public class ValidPalindrome2 {
    public boolean validPalindrome(String s) {

//        return helper(s, 1);
//        return helper2(0, s.length() - 1, 1, s.toCharArray(), new HashMap<>());
        return helper(0, s.length() - 1, s.toCharArray(), 1);
    }


    private boolean helper2(int left, int right, int maxDiff, char[] s, Map<String, Boolean> lookup) {
        String key = left + "," + right + "," + maxDiff;
        if (lookup.containsKey(key)) {
            return lookup.get(key);
        }
         if (maxDiff < 0) {
            lookup.put(key, false);
        } else if (right - left + 1 < 2) {
            lookup.put(key, true);
        } else {
            char a = s[left];
            char b = s[right];
            if (a == b) {
                boolean valid = helper2(left + 1, right - 1, maxDiff, s, lookup);
                lookup.put(key, valid);
            } else {
                boolean valid = helper2(left + 1, right, maxDiff - 1, s, lookup) ||
                        helper2(left, right -1 , maxDiff - 1, s, lookup);
                lookup.put(key, valid);
            }
        }
        return lookup.get(key);
    }

    private boolean helper(int left, int right, char[] s, int maxDiff) {
        if (right - left + 1 < 2) {
            return maxDiff >= 0;
        }
        char a = s[left];
        char b = s[right];
        if (a == b) {
            return helper(left + 1, right - 1, s, maxDiff);
        } else {
            return maxDiff > 0 &&( helper (left + 1, right, s, maxDiff - 1) ||
                    helper(left, right -1, s, maxDiff - 1));
        }
    }

    public static void main(String[] args) {
        ValidPalindrome2 val = new ValidPalindrome2();
        System.out.println(val.validPalindrome("abc"));
        System.out.println(val.validPalindrome("accca"));
        System.out.println(val.validPalindrome("bddb"));
    }
}
