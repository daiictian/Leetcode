/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * 
 * 
 * The solution first creates a circular linked list by pointing the tail to head.
 * Then computes the number of places the rotation has to be done in a circular manner.
 * Finally it identifies the tail in the rotated list and breaks the circular property
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null){
            return null;
        }
        if(head.next == null){
            return head;
        }

        int n = 0;
        ListNode result = null;
        ListNode curr = head;
        while(curr.next != null){
            curr = curr.next;
            n++;
        }
        n++;

        while(k >= n){
            k = k%n;
        }
        // System.out.println(k);
        if(k == 0){
            curr.next = null;
            return head;

        }
        curr.next = head;
        curr = head;
        k = n-k-1;
        while(k > 0){

            curr = curr.next;
            k--;
        }

        result = curr.next;
        curr.next = null;
        return result;


    }
}
