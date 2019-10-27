package org.jace.cs.review.lc.dp.p10;

import org.jace.cs.review.lc.dp.Util;

public class Solution {
    public boolean isMatch(String s, String p) {

        s = "#" + s;
        p = "#" + p;

        boolean[][] matchingTable = new boolean[p.length()][s.length()];
        matchingTable[0][0] = (p.charAt(0) == '.' || p.charAt(0) == s.charAt(0));

        for (int i = 1; i < p.length(); i++) {
            matchingTable[i][0] = p.charAt(i) == '*' && ((i - 2 < 0 || matchingTable[i - 2][0]) ||  matchingTable[i - 1][0]);
        }

        for (int i = 1; i < matchingTable.length; i++) {
            for (int j = 1; j < matchingTable[i].length; j++) {
                if (p.charAt(i) == '.') {
                    matchingTable[i][j] = matchingTable[i - 1][j - 1];
                } else if(p.charAt(i) == '*') {
                    //i-2,j means does not use any * to match the j
                    boolean matchingWithoutStar = (i - 2 < 0 || matchingTable[i - 2][j]);
                    boolean matchingWithStar = (matchingTable[i][j-1] ) && (s.charAt(j) == p.charAt(i-1) || p.charAt(i-1) == '.');
                    matchingTable[i][j] = matchingWithoutStar || matchingWithStar;
                } else {
                    matchingTable[i][j] = matchingTable[i - 1][j - 1] && p.charAt(i) == s.charAt(j);
                }
            }
        }
        Util.print2DArray(matchingTable);
        return matchingTable[p.length() - 1][s.length() - 1];
    }
}
