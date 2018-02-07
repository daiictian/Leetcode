class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        
        int consec[] = new int[nums.length];
        int consec2[] = new int[nums.length];
        for(int i=0; i < nums.length; i++){
            if(nums[i] == 1){
                if(i-1 >= 0)
                consec[i] = consec[i-1]+1;
                else{
                consec[i] = 1;
                }
            }
        }
        
        for(int i=nums.length-1; i >= 0; i--){
            if(nums[i] == 1){
                if(i+1 < nums.length)
                consec2[i] = consec2[i+1]+1;
                else{
                consec2[i] = 1;
                }
            }
        }
        int max = 0;
        for(int i=0; i < nums.length; i++){
           
               
                if(i-1 >= 0 && i+1 < nums.length){
                    max = Math.max(max, 1 + consec[i-1] + consec2[i+1]);
                }else if(i-1 < 0 && i+1 < nums.length){
                    max = Math.max(max, 1+consec2[i+1]);
                }else if(i-1 >=0  && i+1 >= nums.length){
                    max = Math.max(max, 1+consec[i-1]);
                }else{
                   max = Math.max(max, 1); 
                }
            
        }
        
        return max;
        
    }
}
