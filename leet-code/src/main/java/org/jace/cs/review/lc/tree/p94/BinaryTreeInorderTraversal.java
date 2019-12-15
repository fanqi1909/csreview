package org.jace.cs.review.lc.tree.p94;

import org.jace.cs.review.lc.tree.TreeNode;

import java.util.*;

public class BinaryTreeInorderTraversal {

    class Pair {
        TreeNode treeNode;
        int visited;

        public Pair(TreeNode root, int i) {
            this.treeNode = root;
            this.visited = i;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        Deque<Pair> stack = new LinkedList<>();
        stack.push(new Pair(root, 0));
        List<Integer> ans = new LinkedList<>();
        while (!stack.isEmpty()) {
            Pair top = stack.pop();
            if (top.treeNode == null) {
                continue;
            }
            if (top.visited == 1) {
//                System.out.print(top.treeNode.val + ","); // visited == 1 means all left children has been processed
                ans.add(top.treeNode.val);
                stack.push(new Pair(top.treeNode.right, 0));
            } else {
                top.visited++;
                stack.push(top);
                stack.push(new Pair(top.treeNode.left, 0));
            }
        }
        return ans;
    }
}
