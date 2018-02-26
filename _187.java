class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> result = new HashSet<String>();
        Set<String> visited = new HashSet<String>();
        for(int i=0; i < s.length()-9; i++){
            String str = s.substring(i,i+10);
            if(visited.contains(str)){
                result.add(str);
            }else{
                visited.add(str);
            }
        }
        return new ArrayList<String>(result);
    }
}
