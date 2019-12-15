package templates;

import org.jace.cs.review.lc.tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class TreeTraverse {

    class Pair {
        TreeNode treeNode;
        int visited;

        public Pair(TreeNode root, int i) {
            this.treeNode = root;
            this.visited = i;
        }
    }


    public void postOrderTraverse(TreeNode root) {
        Deque<Pair> stack = new LinkedList<>();
        stack.push(new Pair(root, 0));

        while (!stack.isEmpty()) {
            Pair top = stack.pop();
            if (top.treeNode == null) {
                continue;
            }
            if(top.visited == 2) {
                System.out.print(top.treeNode.val + ","); // visited == 2 means all right children has been processed
            } else if (top.visited == 1) {
                top.visited++;
                stack.push(top); // visited == 1 means all left children has been processed
                if (top.treeNode.right != null) {
                    stack.push(new Pair(top.treeNode.right, 0));
                }
            } else {
                top.visited++;
                stack.push(top); // visited == 0, means no children has been processed
                if (top.treeNode.left != null) {
                    stack.push(new Pair(top.treeNode.left, 0));
                }
            }
        }
    }

    public void inOrderTraverse(TreeNode root) {
        Deque<Pair> stack = new LinkedList<>();
        stack.push(new Pair(root, 0));

        while (!stack.isEmpty()) {
            Pair top = stack.pop();
            if (top.treeNode == null) {
                continue;
            }
            if (top.visited == 1) {
                System.out.print(top.treeNode.val + ","); // visited == 1 means all left children has been processed
                if (top.treeNode.right != null) {
                    stack.push(new Pair(top.treeNode.right, 0));
                }
            } else {
                top.visited++;
                stack.push(top);
                if (top.treeNode.left != null) {
                    stack.push(new Pair(top.treeNode.left, 0));
                }
            }
        }
    }

    // in the pre-order traverse, the count is not necessary, because all nodes are output the first time it is popped
    public void preOrderTraverse(TreeNode root) {
        Deque<Pair> stack = new LinkedList<>();
        stack.push(new Pair(root, 0));
        while (!stack.isEmpty()) {
            Pair top = stack.pop();
            if (top.treeNode == null) {
                continue;
            }
            if(top.visited == 0) { // visited == 0, means no children has been processed
                System.out.print(top.treeNode.val + ",");
                if (top.treeNode.right != null) {
                    stack.push(new Pair(top.treeNode.right, 0));
                }
                if (top.treeNode.left != null) {
                    stack.push(new Pair(top.treeNode.left, 0));
                }
            }
        }
    }




    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(8);
        TreeNode t9 = new TreeNode(9);
        TreeNode t10 = new TreeNode(10);
        TreeNode t11 = new TreeNode(11);

        /**
         *              1
         *          /      \
         *         2        3
         *        / \      / \
         *       4   5     6  7
         *      /   / \     \
         *     8   9  10    11
         */

        TreeTraverse treeTraverse = new TreeTraverse();


        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        t4.left = t8;
        t5.left = t9;
        t5.right = t10;
        t6.right = t11;

        System.out.println("In order");
        treeTraverse.inOrderTraverse(t1);

        System.out.println("\nPre order");
        treeTraverse.preOrderTraverse(t1);

        System.out.println("\nPost order");
        treeTraverse.postOrderTraverse(t1);
    }
}
