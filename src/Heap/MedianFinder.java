package Heap;


// 295. Find Median from Data Stream

public class MedianFinder {
    Heap<Integer> minHeap;
    Heap<Integer> maxHeap;
//    PriorityQueue<Integer> minHeap;
//    PriorityQueue<Integer> maxHeap;


    public MedianFinder() {
        minHeap = new Heap<Integer>(true);
        maxHeap = new Heap<Integer>(false);
//        this.minHeap = new PriorityQueue<>();
//        this.maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    }

    public void addNum(int num) {
        if (maxHeap.isEmpty()) {
            maxHeap.add(num);
            return;
        }
        if (num < maxHeap.peek()) {
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }

        if (minHeap.size() > maxHeap.size() + 1) {

            maxHeap.add(minHeap.poll());
        } else if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(maxHeap.poll());
        }
    }

    public double findMedian() {
        if (minHeap.size() == maxHeap.size()) {
            return (Double.valueOf(minHeap.peek()) + Double.valueOf(maxHeap.peek())) / 2.0;
        }
        return (minHeap.size() > maxHeap.size()) ? minHeap.peek() : maxHeap.peek();
    }
}

