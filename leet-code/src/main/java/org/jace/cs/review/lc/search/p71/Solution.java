package org.jace.cs.review.lc.search.p71;

import java.util.Stack;

public class Solution {
    public String simplifyPath(String path) {
        String[] folders = path.split("/");

        Stack<String> simp = new Stack<>();
        for(String folder : folders) {
            if(!folder.isEmpty()
            && !".".equals(folder)) {
                if("..".equals(folder)) {
                    if(!simp.isEmpty()) {
                        simp.pop();
                    }
                } else {
                    simp.push(folder);
                }
            }
        }
        StringBuilder result = new StringBuilder();
        while(!simp.isEmpty()) {
            result.insert(0, "/" +simp.pop());
        }
        if(result.length() == 0) result = new StringBuilder("/");
        return result.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.simplifyPath("/home/"));
        System.out.println(solution.simplifyPath("/../"));
        System.out.println(solution.simplifyPath("/home//foo/"));
        System.out.println(solution.simplifyPath("/a/./b/../../c/"));
        System.out.println(solution.simplifyPath("/a/../../b/../c//.//"));
        System.out.println(solution.simplifyPath("/a//b////c/d//././/.."));

    }
}
