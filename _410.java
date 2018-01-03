/*
The idea is to partition the given array into m subarrays and then return the minimum of the maximum sum subarrays.
The recursion will cause the same subproblems to be computed again. Hence memoize the overlapping subproblems in an array
The memoization array is a 2-D array where M[i][j] represents the solution to the problem of partitioning given array into i subarrays of the subarray (j,n) where n is the last element of the array
*/
class Solution {
    Integer[][] M;
    public int splitArray(int[] nums, int m) {
        int[] cumSum = new int[nums.length+1];
        M = new Integer[m][nums.length+1];
        for(int i=0; i < nums.length; i++){
            cumSum[i+1] = nums[i] + cumSum[i];
        }
        
        return rec(nums,0,m-1,cumSum);
        
    }
    private int rec(int[] nums, int start, int m, int[] cumSum){
       if( m == 0){
           if(start < nums.length){
                return cumSum[nums.length] - cumSum[start];
           }else if(start >= nums.length){
                return 0;
           }
           
       }
        if(M[m][start+1] == null){
        int max = 0;
        int result = Integer.MAX_VALUE;
        for(int i=start; i< nums.length-1; i++){
            int x = 0;
             x = cumSum[i+1] - cumSum[start];
            int y = rec(nums,i+1,m-1,cumSum);
           // System.out.println("x is " + x + " y is " + y + " diff is " + Math.abs(x-y));
            max = Math.max(x,y);
            result = Math.min(result,max);
            //System.out.println(" result is " + result);
            
        }
            M[m][start+1] = result;
        }
        return M[m][start+1];
    }
}
