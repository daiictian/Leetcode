/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 
 The idea for this solution is as follows:
 1. First find the number of elements in the list;
 2. Find the max value in the list. Adjust the max value so that it is divisible by number of elements in the list.
 3. Create buckets equal to the number of elements, where ith bucket will contain the range of value (bucketsize, bucketsize*i).
 4. Put each element at ith index in ith bucket
 5. Generate random number "value" betwen 0 to max and find which bucket this value falls in by computing value%(number of elements).
 6. Return the value at this bucket.
 */
class Solution {

    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    int numElements = 0;
    ListNode root;
    int max = Integer.MIN_VALUE;
    Map<Integer,ListNode> M;
    Random random; 
    public Solution(ListNode head) {
        ListNode curr = head;
        root = head;
        M = new HashMap<Integer,ListNode>();
        random = new Random();
        while(curr != null){
            numElements++;
            if(max < curr.val){
                max = curr.val;
            }
            curr = curr.next;
        }
       fillMap(root); 
        
    }
    private void fillMap(ListNode root){
        ListNode curr = root;
        
        
        if(max%numElements != 0){
            max = max + max%numElements;
        }
        int bucketSize = max/numElements;
        int x = 0;
         
        for( int i=0; x < max; i++){
            x = x + bucketSize;
            M.put(i,curr);
           if(curr != null){
            curr = curr.next;
           }else{
               break;
           }
            
        }
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
       
        int x = random.nextInt(max);
        // System.out.println(x);
        x = x%numElements;
        // System.out.println(x);
        return M.get(x).val;
        
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
