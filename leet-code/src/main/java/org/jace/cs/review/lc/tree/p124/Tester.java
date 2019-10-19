package org.jace.cs.review.lc.tree.p124;

import org.jace.cs.review.lc.tree.TreeNode;

import java.util.Arrays;

public class Tester {
    public static void main(String[] args) {

        Solution solution = new Solution();
        runTest(new Integer[]{1,2,3}, solution);
        runTest(new Integer[]{-10,9,20, null, null, 15,7}, solution);
        runTest(new Integer[]{-3}, solution);
    }

    private static void runTest(Integer[] integers, Solution solution) {
        //convert integers to tree node;
        TreeNode root = convertArrayToTree(integers);
        System.out.println(root);
        System.out.printf("%s === %d\n", Arrays.toString(integers), solution.maxPathSum(root));
    }

    private static TreeNode convertArrayToTree(Integer[] integers) {
        TreeNode[] treeNodes = new TreeNode[integers.length];
        for(int i = 0; i < integers.length; i++) {
            if(integers[i] == null) {
                treeNodes [i] = null;
            } else {
                treeNodes [i] = new TreeNode(integers[i]);
            }
        }
        for(int i = 0; i < treeNodes.length; i++) {
            if(2 * i + 1 < treeNodes.length) {
                treeNodes[i].left = treeNodes[2 * i + 1];
            }
            if(2 * i + 2 < treeNodes.length) {
                treeNodes[i].right = treeNodes[2 * i + 2];
            }
        }
        return  treeNodes[0];
    }

}
