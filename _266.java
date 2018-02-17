class Solution {
    public boolean canPermutePalindrome(String s) {
        Map<Character,Integer> M = new HashMap<Character,Integer>();
        for(int i=0; i < s.length(); i++){
            M.put(s.charAt(i),M.getOrDefault(s.charAt(i),0)+1);
        }
        int odd = 0;
        for(Integer val : M.values()){
            if(val%2 == 1) odd++;
        }
        if(odd > 1) return false;
        return true;
    }
}
