package contest.c169;

import org.jace.cs.review.lc.tree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Q2 {

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> sorted1 = new ArrayList<>();
        List<Integer> sorted2 = new ArrayList<>();
        sorted(root1, sorted1);
        sorted(root1, sorted2);
        sorted1.addAll(sorted2);
        Collections.sort(sorted1);
        return sorted1;
    }

    private void sorted(TreeNode root1, List<Integer> ans) {
        if(root1 != null) {
            sorted(root1.left, ans);
            ans.add(root1.val);
            sorted(root1.right, ans);
        }
    }


    public static void main(String[] args) {
        Q2 sol = new Q2();
    }
}
