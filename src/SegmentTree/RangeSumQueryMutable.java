package SegmentTree;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RangeSumQueryMutable {
}


class NumArray {
    SegmentTree<Integer> segmentTree;

    public NumArray(int[] nums) {
        List<Integer> arr = IntStream.of(nums) // Convert int[] to IntStream
                .boxed()  // Convert each int to Integer
                .collect(Collectors.toCollection(ArrayList::new));
        segmentTree = new SegmentTree<Integer>(arr, new BinaryOperator(), new UpdateOperator());

    }

    public void update(int index, int val) {
        segmentTree.update(index, val);
    }

    public int sumRange(int left, int right) {
        return segmentTree.getRangeQuery(left, right);
    }
}

class BinaryOperator implements BinaryOp<Integer> {

    @Override
    public Integer op(Integer first, Integer second) {
        if(first == null) {
            first = 0;
        }
        if ((second == null)) {
            second = 0;
        }
        return first + second;
    }
}

class UpdateOperator implements BinaryOp<Integer> {

    @Override
    public Integer op(Integer first, Integer second) {
        if(first == null) {
            first = 0;
        }
        if ((second == null)) {
            second = 0;
        }
        return second;
    }
}