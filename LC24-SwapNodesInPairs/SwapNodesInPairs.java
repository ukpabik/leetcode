
class Solution {

  // ListNode class
  public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }


  // O(N) Solution
  public ListNode swapPairs(ListNode head) {
    int count = 0;


    ListNode curr = head, prev = null;
    // Getting the length of the list
    while (curr != null){
      curr = curr.next;
      count++;
    }

    // Get our number of swaps, and reset the curr to the head
    int numSwaps = count / 2;
    curr = head;


    // Loop through while you are able to swap
    while (numSwaps > 0 && curr != null && curr.next != null){

      // On the first iteration, update the head as prev will be null
      if (prev == null){
        head = swap(curr);
      }
      // Else, update prev's next to the new head of the swapped pair
      else{
        prev.next = swap(curr);
      }

      // Update prev and move curr forward
      prev = curr;
      curr = curr.next;
      numSwaps--;
    }

    return head;
  }

  // Helper swap function
  public ListNode swap(ListNode node){
    if (node == null || node.next == null){
      return node;
    }
    ListNode next = node.next;

    node.next = next.next;
    next.next = node;

    return next;
  }


}
