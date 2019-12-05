package ps.google.design;

import org.jace.cs.review.lc.tree.TreeNode;

import java.util.*;

/**
 * Use preorder traversal to record the tree structure, and reconstruct from the preorder traces
 * The trick is to use "nulls" to determine the ending positions of final child. Without the nulls, there is no
 * way to construct a tree back uniquely.
 *
 * This is also different from the question to reconstruct tree based on pre/in order traverse. Because those traces does
 * not have "null"s.
 *
 * Post order traversal can be used here too. in-order traversal trace would not work as there would not be a ROOT to start with.
 *
 */
public class TreeCodec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> preorder = new LinkedList<>();
        pushNode(root, preorder);
        System.out.println(preorder);
        return String.join(",", preorder);
    }

    private void pushNode(TreeNode root, List<String> preorder) {
        if (root == null) {
            preorder.add("");
        } else {
            preorder.add(root.val + "");
            pushNode(root.left, preorder);
            pushNode(root.right, preorder);
        }
    }

    public TreeNode decode(List<Integer> traces) {
        if(traces.size() == 0) {
            return null;
        }

        Integer first = traces.remove(0);

        if(first == null) {
            return null;
        }

        TreeNode root = new TreeNode(first);

        root.left = decode(traces);
        root.right = decode(traces);
        return root;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<Integer> preOrder = new LinkedList<>();
        Arrays.stream(data.split(",", -1))
                .map(s -> s.isEmpty() ? null : Integer.parseInt(s)).forEach(preOrder::add);
        return decode(preOrder);
    }


    public static void main(String[] args) {
        TreeCodec treeCodec = new TreeCodec();
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        n1.left = n2;
        n1.right = n3;
        n3.left = n4;
        n3.right = n5;
        String serial = treeCodec.serialize(n1);
        System.out.println(serial);
        System.out.println(n1);
        System.out.println(treeCodec.deserialize(serial));


        n1 = new TreeNode(1);
        n2 = new TreeNode(2);
        n3 = new TreeNode(3);
        n4 = new TreeNode(4);
        n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);
        TreeNode n9 = new TreeNode(9);
        TreeNode n10 = new TreeNode(10);
        TreeNode n11 = new TreeNode(11);
        TreeNode n12 = new TreeNode(12);
        TreeNode n13 = new TreeNode(13);
        TreeNode n14 = new TreeNode(14);
        TreeNode n15 = new TreeNode(15);

        n1.right = n2;
        n2.right = n3;
        n3.right = n4;
        n4.right = n5;
        n5.right = n6;
        n6.right = n7;
        n7.right = n8;
        n8.right = n9;
        n9.right = n10;
        n10.right = n11;
        n11.right = n12;
        n12.right = n13;
        n13.right = n14;
        n14.right = n15;
        serial = treeCodec.serialize(n1);
        System.out.println(serial);
        System.out.println(n1);
        System.out.println(treeCodec.deserialize(serial));


        serial = treeCodec.serialize(null);
        System.out.println(serial);
        System.out.println("null");
        System.out.println(treeCodec.deserialize(serial));

        n1 = new TreeNode(1);
        n2 = new TreeNode(2);
        n1.left = n2;
        serial = treeCodec.serialize(n1);
        System.out.println(serial);
        System.out.println(n1);
        System.out.println(treeCodec.deserialize(serial));
    }
}
