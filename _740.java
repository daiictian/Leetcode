class Solution {
    Integer[][] M;
    public int deleteAndEarn(int[] nums) {
        if(nums.length == 0) return 0;
        Arrays.sort(nums);
        M = new Integer[nums[nums.length-1]+2][nums.length];
        return rec(nums,0,nums.length-1, 0);
    }
    
    private int rec(int[] nums, int start, int end, int toSkip){
        if(start > end ) return 0;
        if(start == end){
            if(nums[start] != toSkip){
                return nums[start];
            }
            return 0;
        }
      
        if(M[toSkip][end-start] == null){
            int x = 0;
        if(nums[start] != toSkip){
            
            x= Math.max(nums[start] + rec(nums,start+1,end,nums[start]+1), rec(nums,start+1,end,toSkip));
        }else{
            x= rec(nums,start+1,end,toSkip);
        }
            M[toSkip][end-start] = x;
        }   
        return M[toSkip][end-start];
        
    }
    
    
}
