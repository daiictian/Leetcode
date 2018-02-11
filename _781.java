class Solution {
    public int numRabbits(int[] answers) {
        Map<Integer,Integer> M = new HashMap<Integer,Integer>();
        for(int i=0; i < answers.length;i++){
            M.put(answers[i],M.getOrDefault(answers[i],0)+1);
        }
        int count = 0;
        for(Integer key : M.keySet()){
            int x = M.get(key);
            
                while(x > key){
                    x = x- (key+1);
                    count += key+1;
                }
                if(x > 0){
                    count += key+1; 
                }
            
            
        }
        return count;
    }
}
