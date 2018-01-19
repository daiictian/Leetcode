class Solution {
    class Tuple{
        int h;
        int v;
        int d;
        int ad;
        
        public String toString(){
            return String.valueOf(h) + ","+String.valueOf(v) + ","+String.valueOf(d) + ","+String.valueOf(ad);
        }
    }
    public int longestLine(int[][] M) {
        if(M.length == 0 || M[0].length == 0){
            return 0;
        }
        Tuple[][] dp = new Tuple[M.length+2][M[0].length+2];
        for(int i=0; i < dp.length; i++){
            for(int j=0; j < dp[0].length; j++){
                dp[i][j] = new Tuple();
            }
        }
        int max = 0;
        for(int i=0; i < M.length; i++){
            for(int j=0; j < M[0].length; j++){
                if(M[i][j] == 1){
                    if(dp[i+1][j].h > 0){
                       dp[i+1][j+1].h = dp[i+1][j].h+1;
                    }else{
                       dp[i+1][j+1].h++; 
                    }
                    if(dp[i][j+1].v > 0){
                       dp[i+1][j+1].v = dp[i][j+1].v+1;;
                    }else{
                       dp[i+1][j+1].v++; 
                    }
                    if(dp[i][j].d > 0){
                       dp[i+1][j+1].d = dp[i][j].d+1;
                    }else{
                       dp[i+1][j+1].d++; 
                    }
                    if(dp[i][j+2].ad > 0){
                       dp[i+1][j+1].ad = dp[i][j+2].ad+1;
                    }else{
                       dp[i+1][j+1].ad++; 
                    }
                    max = Math.max(max,dp[i+1][j+1].h);
                    max = Math.max(max,dp[i+1][j+1].v);
                    max = Math.max(max,dp[i+1][j+1].d);
                    max = Math.max(max,dp[i+1][j+1].ad);
                }
            }
        }
        /*
        for(int i=1; i < dp.length-1; i++){
            for(int j=1; j < dp[0].length-1; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        */
        return max;
    }
}
