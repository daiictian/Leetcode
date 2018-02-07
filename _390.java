class Solution {
    public int lastRemaining(int n) {
        return rec(1,n,0,n,1);
    }
    
    private int rec(int min, int max, int dir, int n, int add){
        if(n == 1){
            if(dir == 0){
                return max;
            }
            return min;
        }
       // System.out.println("min : " + min + " max :" + max);
        if(n%2 == 1){
            if(dir == 0)
             return rec(min+add,max-add,1,(n-1)/2,add*2);
            else
            return rec(min+add,max-add,0,(n-1)/2,add*2);
        }else{
            if(dir==0){
            return rec(min+add,max,1,n/2,add*2);
            }else{
             return rec(min,max-add,0,n/2,add*2);   
            }
        }
    }
}
