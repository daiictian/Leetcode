class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> M = new HashMap<Integer,Integer>();
        int sum = 0;
        M.put(0,1);
        int count = 0;
        for(int i=0; i < nums.length; i++){
            sum += nums[i];
            if(M.containsKey(sum-k)){
                count += M.get(sum-k);
            }
            M.put(sum, M.getOrDefault(sum,0)+1);
        }
        return count;
    }
}
