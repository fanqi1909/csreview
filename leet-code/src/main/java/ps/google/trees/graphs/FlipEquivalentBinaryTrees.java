package ps.google.trees.graphs;

import org.jace.cs.review.lc.tree.TreeNode;

/**
 * Recursively compare all sub structures.
 */
public class FlipEquivalentBinaryTrees {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null){
            return true;
        } else if(root1 == null || root2 == null) {
            return false;
        } else if(root1.val != root2.val) {
            return false;
        } else {
            return (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right))
                    || (flipEquiv(root1.right, root2.left) && flipEquiv(root1.left, root2.right));
        }
    }

    public static void main(String[] args) {
        TreeNode[] tree1 = new TreeNode[8];
        for(int i = 0 ; i < tree1.length; i++) {
            tree1[i] = new TreeNode(i);
        }
        TreeNode[] tree2 = new TreeNode[8];
        for(int i = 0 ; i < tree2.length; i++) {
            tree2[i] = new TreeNode(i);
        }

        tree1[0].left = tree1[1]; tree1[0].right = tree1[2];
        tree1[1].left = tree1[3]; tree1[1].right = tree1[4];
        tree1[4].left = tree1[6]; tree1[4].right = tree1[7];
        tree1[2].left = tree1[5];


        tree2[0].left = tree2[2]; tree2[0].right = tree2[1];
        tree2[2].right = tree2[5]; tree2[1].left = tree2[3];
        tree2[1].right = tree2[4]; tree2[4].left = tree2[7]; tree2[4].right = tree2[6];

        FlipEquivalentBinaryTrees flip = new FlipEquivalentBinaryTrees();
        System.out.println(flip.flipEquiv(tree1[0], tree2[0]));
    }
}
