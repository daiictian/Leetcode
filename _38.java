class Solution {
    public String countAndSay(int n) {
        if(n == 1){
            return "1";
        }
        if(n == 2){
            return "11";
        }
        String s = countAndSay(n-1);
        char prev = s.charAt(0);
        int count = 1;
        StringBuilder sb = new StringBuilder();
        for(int i=1; i< s.length(); i++){
            if(prev != s.charAt(i)){
                sb.append(String.valueOf(count)+prev);
                prev = s.charAt(i);
                count = 1;
            }else{
                count++;
            }
        }
        sb.append(String.valueOf(count)+prev);
        return sb.toString();
    }
}
