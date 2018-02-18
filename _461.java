class Solution {
    public int hammingDistance(int x, int y) {
        int temp = x^y;
        int yo = 1;
        int count = 0;
        for(int i=0; i < 32; i++){
            if((yo&temp) == yo){
                count++;
            }
            yo = yo<<1;
        }
        return count;
    }
}
