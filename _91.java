class Solution {
    public int numDecodings(String s) {
        if(s.length() == 0){
            return 0;
        }
        int[] dp = new int[s.length()];
        if(s.charAt(0) != '0'){
            dp[0] = 1;
        }else{
            dp[0] = 0;
            return 0;
        }
        if(s.length() > 1){
        if(s.charAt(1) != '0'){
         int x = Integer.valueOf(s.substring(0,2));
         if(x >= 10 && x <= 26){
             dp[1] = 2;
         }else{
             dp[1] = 1;
         }
        }else{
              int y = Integer.valueOf(s.substring(0,2));
                if(y >= 10 && y <= 26){
                    dp[1] = 1;
                   // i++;
                }else{
                        return 0;
                }
        }
         
            for(int i=2; i < s.length(); i++){
                if(s.charAt(i) != '0'){
                int y = Integer.valueOf(s.substring(i-1,i+1));
                if(y >= 10 && y <= 26){
                    dp[i] = dp[i-1] + dp[i-2];
                }else{
                        dp[i] = dp[i-1];
                }
            }else{
                  int y = Integer.valueOf(s.substring(i-1,i+1));
                if(y >= 10 && y <= 26){
                    dp[i] = dp[i-2];
                   // i++;
                }else{
                        return 0;
                }
                    
                }
            }
            
        }
        return dp[s.length()-1];
    }
        
}
