class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        rec(result, new ArrayList<Integer>(),nums,0);
        return result;
    }
    
    private void rec(List<List<Integer>> result, List<Integer> path, int[] nums, int start){
        result.add(new ArrayList<Integer>(path));
        
        if(start >= nums.length){
            return;
        }
        for(int i=start; i < nums.length; i++){
            if(i != start && i-1 >= 0 && nums[i] == nums[i-1])continue;
            path.add(nums[i]);
            rec(result,path,nums,i+1);
            path.remove(path.size()-1);
        }
    }
}
