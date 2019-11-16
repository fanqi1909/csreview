package org.jace.cs.review.lc.tree.p95;

import org.jace.cs.review.lc.tree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public List<TreeNode> generateTrees(int n) {
        if(n < 1) {
            return Collections.emptyList();
        }
        return generateTreeRange(1, n);
    }

    private List<TreeNode> generateTreeRange(int left, int right) {
        List<TreeNode> result = new ArrayList<>();
        if (right < left) {
            result.add(null);
            return result;
        } else if (left == right) {
            result.add(new TreeNode(left));
            return result;
        } else {
            for (int i = left; i <= right; i++) {
                List<TreeNode> leftSubTree = generateTreeRange(left, i - 1);
                List<TreeNode> rightSubTree = generateTreeRange(i + 1, right);
                for (TreeNode leftRoot : leftSubTree) {
                    for (TreeNode rightRoot : rightSubTree) {
                        TreeNode root = new TreeNode(i);
                        root.left = leftRoot;
                        root.right = rightRoot;
                        result.add(root);
                    }
                }
            }
            return result;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.generateTrees(3));

        System.out.println(solution.generateTrees(2));

        System.out.println(solution.generateTrees(1));
    }
}
