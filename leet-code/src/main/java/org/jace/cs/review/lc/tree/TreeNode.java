package org.jace.cs.review.lc.tree;

import java.lang.annotation.Target;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        String ls, rs;
        ls = left == null ? "" : left.toString();
        rs = right == null? "" : right.toString();
        if(ls.equals("") && rs.equals("")) {
            return String.format("%d", val);
        } else {
            return String.format("%d->[%s][%s]", val, ls, rs);
        }
    }
}
