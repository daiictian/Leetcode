class Solution {
    public int removeDuplicates(int[] nums) {
        int index = 0;
        int count = 1;
        Integer prev = null;
        for(int i=0; i < nums.length; i++){
            if(prev == null){
                prev = nums[i];
                nums[index] = nums[i];
                index++;
            }else{
                if(prev == nums[i]){
                    count++;
                    if(count <= 2){
                      nums[index] = nums[i];
                        index++;  
                    }
                }else{
                    prev = nums[i];
                    count = 1;
                    nums[index] = nums[i];
                        index++; 
                }
            }
        }
        return index;
        
    }
}
