package Tree;

public class Main {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        node1.left = node2;
        node2.left = node3;
        node3.right = node4;
        Codec codec = new Codec();
        String res = codec.serialize(node1);
        System.out.println(res);
    }
}
