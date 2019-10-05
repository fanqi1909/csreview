package org.jace.cs.review.lc.string.p13;

public class Solution {

    public int romanToInt(String s) {
        int result = 0;
        int i = 0;
        for(; i < s.length() - 1; i++) {
            char roman = s.charAt(i);
            char nextRoman = s.charAt(i+1);
            result += decode(roman, nextRoman);
        }
        result += decode(s.charAt(i), ' ');
        return result;
    }

    private int decode(char s1, char s2) {
        switch (s1) {
            case 'M' : return 1000;
            case 'D' : return 500;
            case 'L' : return 50;
            case 'V' : return 5;
            case 'C' : if (s2 == 'D' || s2 == 'M') return -100; else return 100;
            case 'X' : if (s2 == 'L' || s2 == 'C') return -10; else return 10;
            case 'I' : if (s2 == 'V' || s2 == 'X') return -1; else return 1;
        }
        throw new RuntimeException("Unrecognized charset");
    }
}