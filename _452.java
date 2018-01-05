class Solution {
    class IntervalSort implements Comparator<int[]>{
        public int compare(int[] a, int[] b){
            return a[0] - b[0];
        }
    }
    public int findMinArrowShots(int[][] points) {
        if(points.length == 0){
            return 0;
        }
        Arrays.sort(points, new IntervalSort());
        int start = points[0][0];
        int end = points[0][1];
        int count = 0;
        for(int i=1; i < points.length; i++){
            if(end >= points[i][0] && end <= points[i][1]){
                start = points[i][0];
                continue;
            }else if(end >= points[i][1]){
                start = points[i][0];
                end = points[i][1];
            }else if(end < points[i][0]){
                count++;
                start = points[i][0];
                end = points[i][1];
            }
        }
        count++;
        return count;
        
    }
}
