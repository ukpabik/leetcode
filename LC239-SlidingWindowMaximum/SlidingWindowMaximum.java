import java.util.LinkedList;
import java.util.Deque;
import java.util.PriorityQueue;

class Solution {


  // Pair helper class
  class Pair<K, V> {
    private final K key;
    private final V value;

    public Pair(K key, V value){
      this.key = key;
      this.value = value;
    }

    public K getKey(){
      return this.key;
    }

    public V getValue(){
      return this.value;
    }
  }


  
  // O(N log k) solution with a maxHeap, each operation in the heap takes O(log k) time
  public int[] maxSlidingWindowHeap(int[] nums, int k){
    if (nums == null || k == 0){
      return new int[0];
    }

    int[] res = new int[nums.length - k + 1];
    // Save our result index for adding result values to array
    int resIndex = 0;
    
    // Initialize our maxHeap
    PriorityQueue<Pair<Integer, Integer>> heap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

    for (int i = 0; i < nums.length; i++){
      // Add our current element as a pair
      heap.add(new Pair<>(i, nums[i]));

      // Removing the current max value in the heap IF that value is outside of our window
      while (heap.peek().getKey() < i - k + 1){
        heap.poll();
      }

      // If we are past the initial window and we have started sliding,
      // we can add our results to the array
      if (i >= k - 1){
        res[resIndex] = heap.peek().getValue();
        resIndex++;
      }

    }


    return res;
  }
  

  // O(N) solution using a double ended queue.
  // I got some help with this solution, I initially thought I could use a heap.
  public int[] maxSlidingWindowDeque(int[] nums, int k) {
    // Base case :)
    if (nums == null || k <= 0) return new int[0];
    int n = nums.length;
    int[] res = new int[n - k + 1];

    // Initialize our double ended queue for keeping track of our window
    Deque<Integer> deque = new LinkedList<>();

    for (int i = 0; i < n; i++){

      // This removes the elements not in our window from the deque
      if (!deque.isEmpty() && deque.peekFirst() < i - k + 1){
        deque.removeFirst();
      }

      // Make sure our largest element in the window is at the front of the deque.
      // We should remove all elements in the deque that are smaller than the current
      while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]){
        deque.removeLast();
      }
      // Add our current index to the deque
      deque.addLast(i);


      // If we are past the initial window size, we can start adding elements to our result.
      if (i >= k - 1){
        res[i - k + 1] = nums[deque.peekFirst()];
      }
    }

    return res;
  }
}

