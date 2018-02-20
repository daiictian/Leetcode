/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null) return true;
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = slow;
        slow = slow.next;
        if(slow == null){
            return true;
        }
        ListNode temp = slow.next;
        if(temp == null){
            if(prev.val == slow.val){
                return true;
            }else{
                return false;
            }
        }
        boolean first = false;
        int count = 1;
        while(fast.next != null && fast.next.next != null){
            
            fast = fast.next.next;
            if(fast.next == null){
                count+=2;
            }else if(fast.next.next == null){
                count++;
            }
            
            if(!first){
            slow.next = prev;
                prev.next = null;
                prev = slow;
                slow = temp;
                temp = temp.next;
                first = true;
            }else{
              slow.next = prev;
                
                prev = slow;
                slow = temp;
                temp = temp.next;
            }
            
            
        }
        if(count%2 == 1) prev = prev.next;
        while(prev != null && slow != null){
            if(prev.val != slow.val) return false;
            prev = prev.next;
            slow = slow.next;
        }
        return true;
    }
}
