package org.jace.cs.review.lc.tree.p94;

import org.jace.cs.review.lc.tree.TreeNode;

import java.util.*;

public class Solution {

    public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> result = new ArrayList<>();
//        inorderRecursive(root, result);
//        return result;
        return dfs(root);
    }

    private List<Integer> dfs(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<Object> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()) {
            Object element = stack.pop();
            if (element instanceof TreeNode) {
                stack.push(((TreeNode) element).right);
                stack.push(((TreeNode) element).val);
                stack.push(((TreeNode) element).left);
            } else if(element != null){
                result.add((int) element);
            }
        }
        return result;
    }

    private void inorderRecursive(TreeNode root, List<Integer> result) {
        if(root != null) {
            inorderRecursive(root.left, result);
            result.add(root.val);
            inorderRecursive(root.right, result);
        }
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        n1.right = n2;
        n2.left = n3;

        Solution s = new Solution();
        System.out.println(s.inorderTraversal(n1));
    }
}
