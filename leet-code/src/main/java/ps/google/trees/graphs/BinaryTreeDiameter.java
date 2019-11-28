package ps.google.trees.graphs;

import org.jace.cs.review.lc.tree.TreeNode;

/**
 * needs to recursion on the left/right paths. Therefore require a third parameter to record the actual max.
 * This is the same tricky as the MaximumPathSum problem
 */
public class BinaryTreeDiameter {

    private int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        max = 0;
        longestPathEndingAt(root);
        return max;
    }

    private int longestPathEndingAt(TreeNode root) {
        if(root == null) return -1;

        int leftMax = longestPathEndingAt(root.left) + 1;

        int rightMax = longestPathEndingAt(root.right) + 1;

        max = Math.max(max, leftMax + rightMax);

        return Math.max(leftMax, rightMax);
    }

    public static void main(String[] args) {
        BinaryTreeDiameter diameter = new BinaryTreeDiameter();
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);

        n1.left = n2; n1.right = n3;
        n2.left = n4; n2.right = n5;

        System.out.println(diameter.diameterOfBinaryTree(n1));
    }
}
