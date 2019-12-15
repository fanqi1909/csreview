package ps.google.trees.graphs;

import org.jace.cs.review.lc.tree.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraverse {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if(root == null) return ans;

        int expect;
        int current;
        int next = 0;
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        expect = 1;
        current = 0;
        List<Integer> level = new LinkedList<>();
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(node.left != null) {
                queue.add(node.left);
                next++;
            }
            if(node.right != null) {
                queue.add(node.right);
                next++;
            }

            level.add(node.val);
            current++;
            if(current >= expect) {
                ans.add(level);
                level = new LinkedList<>();
                expect = next;
                next = 0;
                current = 0;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(3);
        TreeNode t2 = new TreeNode(9);
        TreeNode t3 = new TreeNode(20);
        TreeNode t4 = new TreeNode(15);
        TreeNode t5 = new TreeNode(7);
        t1.left = t2;
        t1.right = t3;
        t3.left = t4;
        t3.right = t5;

        BinaryTreeLevelOrderTraverse blt = new BinaryTreeLevelOrderTraverse();
        System.out.println(blt.levelOrder(t1));

    }
}
