class Solution {
    public double myPow(double x, int n) {
        // System.out.println( " n is "+n);
        if(n < 0){
            if(n == Integer.MIN_VALUE){
                return (1.000/x)*(1.000/myPow(x,-1*(n+1)));
            }else{
                return 1.000/myPow(x,-1*n);
            }
        }
        if(x == 0){
            return x;
        }
        if(n == 0){
            return 1.000;
        }
        if(n == 1){
            return x;
        }

        if(n%2 == 1){
            double yo = myPow(x,(n-1)/2);
            return x*yo*yo;
        }else{
            double yo = myPow(x,n/2);

            return yo*yo;
        }

    }
}
