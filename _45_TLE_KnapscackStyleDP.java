class Solution {
    Integer[][] M ;
    public int jump(int[] nums) {
        M = new Integer[nums.length+1][nums.length];
        return rec(nums,0,0);
    }
    
    private int rec(int[] nums, int start, int moves){
        if(start >= nums.length -1){
            return moves;
        }
        if(M[moves][start] == null){
        int x = nums[start];
        int max = Integer.MAX_VALUE;
        for(int i=start+1; i <= start+x; i++){
            max = Math.min(max,rec(nums,i,moves+1));
        }
            M[moves][start] = max;
        }
        return M[moves][start];
    }
}
