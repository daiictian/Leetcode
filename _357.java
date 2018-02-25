class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        return rec(n);
    }
    
    private int rec(int n){
        if(n == 1){
            return 10;
        }
        if(n == 0) return 1;
        int x = 9;
        int y = 9;
        for(int i=0; i < n-1; i++){
            x = x*y;
            y--;
        }
        return x + rec(n-1);
    }
}
