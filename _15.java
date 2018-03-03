class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for(int i=0; i < nums.length - 2; i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int l = i+1;
            int h = nums.length-1;
            int k = 0 - nums[i];
            while(l < h){
                if(nums[l] + nums[h] == k){
                    result.add(Arrays.asList(nums[i],nums[l],nums[h]));
                    l++;
                    h--;
                    while(l < h && nums[l] == nums[l-1]) l++;
                    while(l < h && nums[h] == nums[h+1]) h--;
                }else if(nums[l] + nums[h] < k){
                    l++;
                }else{
                    h--;
                }
                
            }
        }
        return result;
        
    }
}
