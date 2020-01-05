package ps.google.trees.graphs;

import org.jace.cs.review.lc.tree.TreeNode;

import java.util.*;

public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> path = new ArrayList<>();
        List<TreeNode> pathP = new ArrayList<>();
        List<TreeNode> pathQ = new LinkedList<>();
        dfs(root, p, q, path, pathP, pathQ);
        Set<Integer> pq = new HashSet<>();
        for(TreeNode qq : pathQ) {
            pq.add(qq.val);
        }

        for(int i = pathP.size() - 1; i >=0; i--) {
            if(pq.contains(pathP.get(i).val)) {
                return pathP.get(i);
            }
        }

        return root;
    }

    private void dfs(TreeNode node, TreeNode p, TreeNode q, List<TreeNode> path, List<TreeNode> pathP, List<TreeNode> pathQ) {
        if(node != null) {
            path.add(node);
            if(node == p) {
                pathP.addAll(path);
            }
            if(node == q) {
                pathQ.addAll(path);
            }
            if(pathQ.isEmpty() || pathP.isEmpty()) {
                dfs(node.left, p, q, path, pathP, pathQ);
                dfs(node.right, p, q, path, pathP, pathQ);
            }
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        LowestCommonAncestor lca = new LowestCommonAncestor();
        TreeNode[] nodes = new TreeNode[9];
        for(int i = 0; i < nodes.length; i++) {
            nodes[i] = new TreeNode(i);
        }
        nodes[3].left=nodes[5];
        nodes[3].right = nodes[1];
        nodes[5].left = nodes[6];
        nodes[5].right = nodes[2];
        nodes[2].left = nodes[7];
        nodes[2].right = nodes[4];
        nodes[1].left = nodes[0];
        nodes[1].right = nodes[8];

        System.out.println(lca.lowestCommonAncestor(nodes[3], nodes[5], nodes[1]).val);

        System.out.println(lca.lowestCommonAncestor(nodes[3], nodes[5], nodes[4]).val);

        System.out.println(lca.lowestCommonAncestor(nodes[3], nodes[7], nodes[8]).val);

        System.out.println(lca.lowestCommonAncestor(nodes[3], nodes[7], nodes[6]).val);
    }
}
