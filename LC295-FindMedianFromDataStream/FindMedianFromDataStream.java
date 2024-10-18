class MedianFinder {

  // Max-heap for the smaller half
  private PriorityQueue<Integer> small;

  // Min-heap for the larger half
  private PriorityQueue<Integer> large;

  public MedianFinder() {
    small = new PriorityQueue<>(Collections.reverseOrder());
    large = new PriorityQueue<>();
  }

  public void addNum(int num) {
    // Add to max-heap first
    small.add(num);

    // Put the largest value from the smaller half to the larger half
    large.add(small.poll());

    // Make sure the larger and smaller heaps have the same size 
    if (large.size() > small.size()) {
      small.add(large.poll());
    }
  }

  public double findMedian() {
    // If the heaps are of equal size, the median is the average of the two roots
    if (small.size() == large.size()) {
      return (small.peek() + large.peek()) / 2.0;
    } 
    // Otherwise, the max-heap contains one more element, so return its root
    else {
      return small.peek();
    }
  }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
