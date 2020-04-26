package contest.c180;

import org.jace.cs.review.lc.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Q3 {

    public TreeNode balanceBST(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        inOrder(root, values);
        System.out.println(values);
        return build(values, 0, values.size() - 1);
    }

    private TreeNode build(List<Integer> values, int left, int right) {
        if(left > right) {
            return null;
        } else if (left == right) {
            return new TreeNode(values.get(left));
        } else {
            int mid = (left + right) >>> 1;
            TreeNode root = new TreeNode(values.get(mid));
            root.left = build(values, left, mid - 1);
            root.right = build(values, mid + 1, right);
            return root;
        }
    }

    private void inOrder(TreeNode root, List<Integer> values) {
        if (root == null) {
            return;
        } else {
            inOrder(root.left, values);
            values.add(root.val);
            inOrder(root.right, values);
        }
    }

    public static void main(String[] args) {

        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        n1.right = n2;
        n2.right = n3;
        n3.right = n4;


        Q3 sol = new Q3();

        System.out.println(sol.balanceBST(n1));
    }
}
