package org.jace.cs.review.lc.tree.p124;

import org.jace.cs.review.lc.tree.TreeNode;

/**
 * Given a non-empty binary tree, find the maximum path sum.
 * For this problem, a path is defined as any sequence of nodes
 * from some starting node to any node in the tree along the parent-child connections.
 * The path must contain at least one node and does not need to go through the root.
 *
 * maxPathEndingAt(TreeNode node) records the maximum length of a path ending at a node.
 * So the maxPathSum is:
 *     maxPathEndingAt(node.left) + maxPathEndingAt(node.right) + node.value
 * To record the global max, a private field is created.
 *
 * To compute maxPathEndingAt, the formular is:
 *
 *    maxPathEndingAt(node) = max(max(maxPathEndingAt(node.left), maxPathEndingAt(node.right)) + node.value, 0)
 * The 0 here means if the maxPathEnding at a node is negative, it is better to not use this node at all, which means 0.
 *
 */
public class Solution {

    private int maxSum;

    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        maxPathEndingAt(root);
        return maxSum;
    }

    private int maxPathEndingAt(TreeNode root) {
        if(root == null) {
            return 0;
        } else {
            int maxLeft = maxPathEndingAt(root.left);
            int maxRight = maxPathEndingAt(root.right);
            int maxChildren = Math.max(maxLeft, maxRight);

            int maxPath = maxLeft + maxRight + root.val;
            if(maxPath > maxSum) {
                maxSum = maxPath;
            }
            if(maxChildren + root.val < 0) {
                return 0;
            } else {
                return maxChildren + root.val;
            }
        }
    }
}
