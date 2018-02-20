/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        return rec(1,n);
    }
    
    private int rec(int start, int end){
        if(start > end){
            return Integer.MAX_VALUE;
        }
        int mid = start + (end-start)/2;
        if(isBadVersion(mid)){
            return Math.min(mid,rec(start,mid-1));
        }else{
            return rec(mid+1, end);
        }
    }
}
