package org.jace.cs.review.lc.array.p1239;

import java.util.*;

public class MaxLenOfUniqueConcatenation {

    public int maxLength(List<String> arr) {
        String[] input = arr.stream().filter(this::unique).toArray(String[]::new);
        int[] map = new int[input.length];
        for(int i = 0 ; i < input.length; i++) {
            map[i] = sign(input[i]);
        }
        return maxLen(0, 0, 0, input, map);
    }

    private int maxLen(int index, int len, int chars, String[] input, int[] map) {
        if(index == input.length) {
            return len;
        } else {
            int ans = maxLen(index + 1, len, chars, input, map);
            if((map[index] & chars) == 0) {
                ans = Math.max(ans, maxLen(index + 1, len + input[index].length(), (chars | map[index]), input, map));
            }
            return ans;
        }
    }

    private int sign(String s) {
        int ans = 0;
        for(char c : s.toCharArray()) {
            ans = ans | (1 << (c-'a'));
        }
        return ans;
    }

    private boolean unique(String s) {
        int[] smap = new int[26];
        for(char c : s.toCharArray()) {
            if(smap[c-'a'] > 0) {
                return false;
            }
            smap[c-'a']++;
        }
        return true;
    }


    public static void main(String[] args) {
        MaxLenOfUniqueConcatenation mluc = new MaxLenOfUniqueConcatenation();
        System.out.println(mluc.maxLength(Arrays.asList("un", "iq", "ue")));
        System.out.println(mluc.maxLength(Arrays.asList("cha", "r", "act", "ers")));
        System.out.println(mluc.maxLength(Collections.emptyList()));
        System.out.println(mluc.maxLength(Collections.singletonList("abcdefghijklmnopqrstuvwxyz")));
        System.out.println(mluc.maxLength(Arrays.asList("abcdefghijklmnopqrstuvwxyza", "abh", "cd", "ef", "gh", "ij")));
        System.out.println(mluc.maxLength(Arrays.asList("abcdefghijklm","bcdefghijklmn","cdefghijklmno","defghijklmnop","efghijklmnopq","fghijklmnopqr","ghijklmnopqrs","hijklmnopqrst","ijklmnopqrstu","jklmnopqrstuv","klmnopqrstuvw","lmnopqrstuvwx","mnopqrstuvwxy","nopqrstuvwxyz","opqrstuvwxyza","pqrstuvwxyzab")));
    }
}
