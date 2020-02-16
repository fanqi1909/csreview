package contest.c172;

import org.jace.cs.review.lc.tree.TreeNode;

public class Q3 {
    public TreeNode removeLeafNodes(TreeNode root, int target) {

        if(root == null) {
            return null;
        }

        if(root.left != null) {
            root.left = removeLeafNodes(root.left, target);
        }
        if(root.right != null) {
            root.right = removeLeafNodes(root.right, target);
        }

        if(root.left == null && root.right == null) {
            if(root.val == target) {
                return null; //delete itself
            }
        }
        return root;
    }

    public static void main(String[] args) {
    }
}
