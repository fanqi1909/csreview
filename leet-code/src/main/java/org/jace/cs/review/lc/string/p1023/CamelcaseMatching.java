package org.jace.cs.review.lc.string.p1023;

import java.util.LinkedList;
import java.util.List;

// use two pointer greedy matching strategy
public class CamelcaseMatching {

    public List<Boolean> camelMatch(String[] queries, String pattern) {

        List<Boolean> ans = new LinkedList<>();
        for(String query : queries) {
            ans.add(match(query.toCharArray(), pattern.toCharArray()));
        }

        return ans;
    }

    private Boolean match(char[] query, char[] pattern) {
        int i = 0;
        int j = 0;
        while(j < pattern.length) {
            if(i >= query.length) {
                return false; // haven't finished with pattern
            } else {
                if(query[i] == pattern[j]) {
                    i++;
                    j++;
                } else {
                    if(Character.isLowerCase(query[i])) {
                        i++;
                    } else {
                        //cannot match
                        return false;
                    }
                }
            }
        }
        while(i < query.length) {
            if(Character.isUpperCase(query[i])) {
                return false;
            }
            i++;
        }
        return true;
    }

    public static void main(String[] args) {
        CamelcaseMatching cm = new CamelcaseMatching();

        System.out.println(cm.camelMatch(new String[]{"FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"}, "FB"));
        System.out.println(cm.camelMatch(new String[]{"FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"}, "FoBa"));
        System.out.println(cm.camelMatch(new String[]{"FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"}, "FoBaT"));
    }
}
