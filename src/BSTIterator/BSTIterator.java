package BSTIterator;


import java.util.Stack;


//Problem 173

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class BSTIterator {
    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        fillLeft(root);
    }

    public int next() {
        TreeNode node = stack.pop();
        fillLeft(node.right);
        return node.val;
    }

    private void fillLeft(TreeNode node) {
        if (node == null) {
            return;
        }
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}





















