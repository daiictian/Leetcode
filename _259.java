class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int count = 0;
        for(int i=0; i < nums.length-2; i++){
            int low = i+1;
            int high = nums.length-1;
            while(low < high){
                if(nums[low] + nums[i] + nums[high] < target){
                    int x = high - low;
                    count += x;
                    low++;
                }else{
                    high--;
                }
            }
            
        }
        return count;
    }
}
