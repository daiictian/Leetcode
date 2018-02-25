class Solution {
    public int maxChunksToSorted(int[] arr) {
        int window = 0;
        
        int left = 0;
        int count = 0;
        while(left < arr.length){
             window = arr[left];
        while(left <= window){
            if(arr[left] <= window){
                left++;
            }else{
                window = arr[left];
                left++;
            }
            
        }
           
            count++;
        }
        
        return count;
    }
}
