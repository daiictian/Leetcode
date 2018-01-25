class Solution {
    public int jump(int[] nums) {
        int farthestAsOfNow = 0;
        int currentEnd = 0;
        int count = 0;
        for(int i=0; i < nums.length; i++){
            farthestAsOfNow = Math.max(farthestAsOfNow,nums[i]+i);
            if(i == currentEnd && currentEnd != nums.length-1){
                count++;
               currentEnd = farthestAsOfNow; 
            }
        }
        return count;
    }
}
