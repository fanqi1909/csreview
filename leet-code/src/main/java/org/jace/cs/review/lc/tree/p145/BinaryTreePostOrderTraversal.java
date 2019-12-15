package org.jace.cs.review.lc.tree.p145;

import org.jace.cs.review.lc.tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreePostOrderTraversal {
    class Pair {
        TreeNode treeNode;
        int visited;

        public Pair(TreeNode root, int i) {
            this.treeNode = root;
            this.visited = i;
        }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        Deque<Pair> stack = new LinkedList<>();
        stack.push(new Pair(root, 0));
        List<Integer> ans = new LinkedList<>();
        while (!stack.isEmpty()) {
            Pair top = stack.pop();
            if (top.treeNode == null) {
                continue;
            }
            if (top.visited == 2) {
//                System.out.print(top.treeNode.val + ","); // visited == 2 means all right children has been processed
                ans.add(top.treeNode.val);
            } else if (top.visited == 1) {
                top.visited++;
                stack.push(top); // visited == 1 means all left children has been processed
                stack.push(new Pair(top.treeNode.right, 0));
            } else {
                top.visited++;
                stack.push(top); // visited == 0, means no children has been processed
                stack.push(new Pair(top.treeNode.left, 0));
            }
        }
        return ans;
    }

}
