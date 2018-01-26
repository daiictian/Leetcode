class Solution {
    public int findMaxLength(int[] nums) {
        int sum = 0;
        int[] yo = new int[nums.length];
        List<Integer> zeros = new ArrayList<Integer>();
        List<Integer> ones = new ArrayList<Integer>();
        boolean zero = false;
        
        Map<Integer,List<Integer>> M = new HashMap<Integer,List<Integer>>();
        for(int i=0; i < nums.length; i++){
            
            if(nums[i]==0){
                sum+= 1;
            }else{
                sum-=1;
            }
           if(M.get(sum) == null){
            List<Integer> l = new ArrayList<Integer>();
               l.add(i);
               M.put(sum,l);
           }else{
               M.get(sum).add(i);
           }
            
        }
        int max = 0;
        Set<Integer> keys = M.keySet();
        for(Integer key : keys){
            List<Integer> ll = M.get(key);
            if(key == 0){
                max = Math.max(max,ll.get(ll.size()-1)+1);
            }else{
               max = Math.max(max,ll.get(ll.size()-1)-ll.get(0)); 
            }
        }
        
        return max;
        
        
        
    }
}
