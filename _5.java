class Solution {
    public String longestPalindrome(String s) {

        String result = "";
        for(int i = 0; i < s.length(); i++){
            String ss = expand(i,s);
            //  System.out.println(ss);
            if(ss.length() > result.length()){
                result = ss;
            }
        }
        if(result.length() == 0){
            return s.substring(0,1);
        }
        return result;

    }

    private String expand(int index, String s){
        int left = index;
        int right = index;
        while(left >= 0 && s.charAt(index) == s.charAt(left)){
            left--;
        }
        while(right < s.length() && s.charAt(index) == s.charAt(right) ){
            right++;
        }
        while((left >= 0 && right < s.length()) && s.charAt(left) == s.charAt(right) ){
            left--;
            right++;
        }
        if(left < 0 && right >= s.length()){
            return s;
        }else if(left < 0 && right < s.length()){
            return s.substring(0,right);
        }else if(left >= 0 && right >= s.length()){
            return s.substring(left+1,right);
        }else{
            return s.substring(left+1,right);
        }



    }


}
