class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        rec(candidates,target, new ArrayList<Integer>(), result,0);
        return result;
        
    }
    
    private void rec(int[] nums, int target, List<Integer> path, List<List<Integer>> result, int start){
        if(target == 0){
            if(path.size() > 0){
                result.add(new ArrayList<Integer>(path));
            }
            return;
        }
        if(target < 0){
            return;
        }
        
        for(int i = start; i < nums.length; i++){
            path.add(nums[i]);
            rec(nums,target - nums[i],path,result,i);
            path.remove(path.size()-1);
        }
    }
}
