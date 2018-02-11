class Solution {
    public List<Integer> partitionLabels(String S) {
        Map<Character,Integer> M = new HashMap<Character,Integer>();
        for(int i=0; i < S.length(); i++){
            M.put(S.charAt(i),M.getOrDefault(S.charAt(i),0)+1);
        }
        int left = 0;
        int right = 0;
        List<Integer> result = new ArrayList<Integer>();
        Set<Character> visited = new HashSet<Character>();
        while(right < S.length()){
            if(M.get(S.charAt(right)) > 1){
                M.put(S.charAt(right), M.get(S.charAt(right))-1);
                visited.add(S.charAt(right));
                right++;
            }else if(M.get(S.charAt(right)) == 1 ){
                M.put(S.charAt(right), M.get(S.charAt(right))-1);
                visited.remove(S.charAt(right));
                right++;
            }
          //  System.out.println("visited is " +visited + " right is "+right);
            if(visited.size() == 0){
                result.add(right-left);
               // right++;
                left = right;
            }
            
        }
        return result;
    }
}
