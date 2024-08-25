package SegmentTree;

import java.util.List;

public class SegmentTree<T> {
    Node<T> root;
    int arrSize;
    BinaryOp<T> binaryOp;
    BinaryOp<T> update;

    SegmentTree(List<T> arr, BinaryOp<T> binaryOp, BinaryOp<T> update) {
        this.binaryOp = binaryOp;
        this.update = update;
        this.arrSize = arr.size();
        buildSegmentTree(arr);
    }

    private void buildSegmentTree(List<T> arr) {
        int left = 0, right = arrSize - 1;
        this.root = fillChildren(arr, left, right);
    }

    public void update(int idx, T value) {
        int left = 0, right = arrSize - 1;
        updateTree(idx, value, root, left, right);
    }

    private void updateTree(int idx, T value, Node<T> node, int left, int right) {
        if (left == right) {
            node.acc = update.op(node.acc, value);
            return;
        }
        int mid = getMid(left, right);
        int leftOfChild = left;
        int rightOfChild = mid;
        Node<T> nodeToBeUpdated = node.left;
        if (idx > mid) {
            leftOfChild = mid + 1;
            rightOfChild = right;
            nodeToBeUpdated = node.right;
        }
        updateTree(idx, value, nodeToBeUpdated, leftOfChild, rightOfChild);
        node.acc = binaryOp.op(node.left.acc, node.right.acc);
    }

    public T getRangeQuery(int left, int right) {
        return getRangeQuery(root, left, right, 0, arrSize-1);
    }

    private T getRangeQuery(Node<T> node, int left, int right, int currLeft, int currRight) {
        if (currLeft >= left && currRight <= right) {
            return node.acc;
        }
        if(currLeft > right || currRight < left) {
            return null;
        }

        int mid = getMid(currLeft, currRight);
        return binaryOp.op(getRangeQuery(node.left, left, right, currLeft, mid), getRangeQuery(node.right,
                left, right, mid + 1, currRight));

    }

    private Node<T> fillChildren(List<T> arr, int left, int right) {
        if (left == right) {
            return new Node<>(arr.get(left));
        }
        int mid = getMid(left, right);
        Node<T> leftNode = fillChildren(arr, left, mid);
        Node<T> rightNode = fillChildren(arr, mid + 1, right);
        T accValue = binaryOp.op(leftNode.acc, rightNode.acc);
        Node<T> node = new Node<>(accValue);
        node.left = leftNode;
        node.right = rightNode;
        return node;
    }

    private int getMid(int left, int right) {
        return (left + right) / 2;
    }
}

class Node<T> {
    T acc;
    Node<T> left, right;

    Node(T acc) {
        this.acc = acc;
    }

    Node() {
    }
}