/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        for(int i=0; i < n-1; i++){
            fast = fast.next;
        }
        while(fast.next != null){
            fast = fast.next;
            prev = slow;
            slow = slow.next;
        }
        if(prev != null){
        prev.next = slow.next;
        slow.next = null;
        }else{
            head = slow.next;
            slow.next = null;
        }
        return head;
        
    }
}
