package contest.p163.p2;

import org.jace.cs.review.lc.tree.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {

        TreeNode n1 = new TreeNode(-1);
        TreeNode n2 = new TreeNode(-1);
        TreeNode n3 = new TreeNode(-1);
        TreeNode n4 = new TreeNode(-1);
        TreeNode n5 = new TreeNode(-1);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        FindElements findElements = new FindElements(n1);
        System.out.println(findElements.cache);
        for(int i = 0; i < 6; i++) {
            System.out.println(i+ "\t" + findElements.find(i));
        }
    }
}

class FindElements {

    //    private TreeNode recoveredRoot;
    Set<Integer> cache;

    public FindElements(TreeNode root) {
        cache = new HashSet<>();
//        recoveredRoot = recover(1, root);
        recover(0, root);
    }

    private TreeNode recover(int x, TreeNode dirty) {
        if (dirty == null) {
            return null;
        } else {
            TreeNode current = new TreeNode(x);
            cache.add(x);
            current.left = recover(x * 2 + 1, dirty.left);
            current.right = recover(x * 2 + 2, dirty.right);
            return current;
        }
    }

    public boolean find(int target) {
        return cache.contains(target);
    }

}