class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        rec(result,new ArrayList<Integer>(),n,k,1);
        return result;
    }
    
    private void rec(List<List<Integer>> result, List<Integer> path, int n, int k, int start){
        if(path.size() == k){
            result.add(new ArrayList<Integer>(path));
        }
        
        for(int i=start; i <= n; i++){
            path.add(i);
            rec(result,path,n,k,i+1);
            path.remove(path.size()-1);
        }
    }
}
