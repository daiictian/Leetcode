class Solution {
    public int numMatchingSubseq(String S, String[] words) {
        Map<Character,Integer> M = new HashMap<Character,Integer>();
        for(int i=0; i < S.length(); i++){
            M.put(S.charAt(i),i);
        }
        int count = 0;
        for(String word : words){
            if(isSubSeq(word,M)){
                    count++;
                }
        }
        return count;
    }
    
    private boolean isSubSeq(String word, Map<Character,Integer> M){
        int prev = -1;
        int curr = -1;
        for(int i=0; i < word.length(); i++){
            if(!M.containsKey(word.charAt(i))){
                return false;
            }
            curr = M.get(word.charAt(i));
            if(prev < curr){
                prev = curr;
            }else{
                return false;
            }
        }
        return true;
    }
}
