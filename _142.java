/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> s = new HashSet<ListNode>();
        ListNode curr = head;
        while(!s.contains(curr) && curr != null){
            s.add(curr);
            curr = curr.next;
        }
        
        return curr;
    }
}
