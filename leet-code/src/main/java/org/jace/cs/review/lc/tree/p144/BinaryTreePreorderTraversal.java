package org.jace.cs.review.lc.tree.p144;

import org.jace.cs.review.lc.tree.TreeNode;
import templates.TreeTraverse;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreePreorderTraversal {
    class Pair {
        TreeNode treeNode;
        int visited;

        public Pair(TreeNode root, int i) {
            this.treeNode = root;
            this.visited = i;
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        Deque<Pair> stack = new LinkedList<>();
        stack.push(new Pair(root, 0));
        List<Integer> ans = new LinkedList<>();
        while (!stack.isEmpty()) {
            Pair top = stack.pop();
            if (top.treeNode == null) {
                continue;
            }
            if (top.visited == 0) { // visited == 0, means no children has been processed
//                System.out.print(top.treeNode.val + ",");
                ans.add(top.treeNode.val);
                stack.push(new Pair(top.treeNode.right, 0));
                stack.push(new Pair(top.treeNode.left, 0));
            }
        }
        return ans;
    }
}
