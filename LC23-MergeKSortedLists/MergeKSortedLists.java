/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
  public ListNode mergeKLists(ListNode[] lists) {

    // Initialize our priority queue (minHeap)
    PriorityQueue<Integer> que = new PriorityQueue<>();

    // Create our dummy node to use for making our new list
    ListNode start = new ListNode(0);
    ListNode prev = start;

    // Put all of the values into the minHeap from the nodes
    for (ListNode node : lists){
      while (node != null){
        que.add(node.val);
        node = node.next;
      }
    }

    // With the minHeap, pop off and create new nodes with the values in sorted order.
    while(!que.isEmpty()){
      ListNode newNode = new ListNode(que.poll());
      start.next = newNode;
      start = newNode;
    }

    // Return the next of the dummy node
    return prev.next;
  }
}
