package Tree;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

// 297. Serialize and Deserialize Binary Tree
public class Codec {
    String nullChar = "#";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();

    }

    private void serialize(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append(nullChar);
            return;
        }
        sb.append(node.val);
        sb.append(',');
        serialize(node.left, sb);
        sb.append(',');
        serialize(node.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<String> dataArr = List.of(data.split(","));
        AtomicInteger pointer = new AtomicInteger(0);
        return deserialize(dataArr, pointer);
    }

    private TreeNode deserialize(List<String> dataArr, AtomicInteger pointer) {

        if (isNextNull(dataArr.get(pointer.get()))) {
            pointer.incrementAndGet();
            return null;
        }

        TreeNode node = getTreeNode(dataArr.get(pointer.get()));
        pointer.incrementAndGet();
        node.left = deserialize(dataArr, pointer);
        node.right = deserialize(dataArr, pointer);
        return node;
    }

    private boolean isNextNull(String value) {
        return value.charAt(0) == nullChar.charAt(0);
    }

    private TreeNode getTreeNode(String data) {
        return new TreeNode(Integer.parseInt(data));
    }
}






















