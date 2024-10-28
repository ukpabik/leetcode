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

  class ListNode{
    int val;
    ListNode next;
    ListNode() {
    }
    ListNode(int val) { this.val = val; }

    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

  public ListNode reverseKGroup(ListNode head, int k) {
    if (head == null) return null;
    if (k <= 1) return head;
    ListNode curr = head;

    // These are our starting and ending nodes for our reversals
    ListNode dummy = new ListNode(0);
    ListNode prevEnd = dummy;

    while (curr != null){
      ListNode end = curr;
      // If end is null in this loop, there arent k nodes in this group
      // Thus, we return the rest of the list
      for (int i = 0; i < k; i++){
        if (end == null){
          prevEnd.next = curr;
          return dummy.next;
        }
        // Move our end forward
        end = end.next;
      }


      // Reverse our current group to get our new reversed head
      ListNode reversed = reverse(curr, end);

      // Link back up our previous group to our currently reversed group
      prevEnd.next = reversed;
      prevEnd = curr;
      curr = end;
    }


    return dummy.next;
  }



  // Reversal helper function that takes in a start node and an end node
  // to keep track of where we want to reverse
  public ListNode reverse(ListNode start, ListNode end){
    ListNode curr = start, prev = null;

    while (curr != end){
      ListNode next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }

    return prev;
  }
}
