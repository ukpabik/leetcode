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

    // O(N) solution that only rotates k % length amount of times
    
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0){
            return head;
        }
        ListNode newHead = head;
        ListNode curr = head;
        int length = 0;

        // Get the length of the list, so that we can determine the correct amount of times to rotate
        while (curr != null){
            curr = curr.next;
            length++;
        }

        // Only rotate k % length amount of times
        for (int i = 0; i < k % length; i++){
            newHead = rotate(newHead);
        }

        return newHead;
    }

    public ListNode rotate(ListNode node){
        if (node == null || node.next == null){
            return node;
        }
        
        // First get the tail and the head as pointers
        ListNode curr = node, tail = null, prev = null;

        while (curr.next != null && curr.next.next != null){
            curr = curr.next; 
        }
        tail = curr.next;
        prev = curr;
        
        // Set the tail node's next to be the head, and set the tail's previous to be null, making it the new tail
        tail.next = node;
        prev.next = null;

        // Return the old tail, which is the new head
        return tail;
    }
}
