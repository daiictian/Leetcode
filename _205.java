class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        Map<Character,Character> M = new HashMap<Character,Character>();
        Set<Character> visited = new HashSet<Character>();
        for(int i = 0; i < s.length(); i++){
            if(!M.containsKey(s.charAt(i))){
                if(!visited.contains(t.charAt(i))){
                    M.put(s.charAt(i),t.charAt(i));
                }else{
                    return false;
                }
            }else{
                if(M.get(s.charAt(i)) != t.charAt(i)){
                    return false;
                }
            }
            visited.add(t.charAt(i));
        }
        return true;
    }
}
