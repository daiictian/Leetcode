class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double[] cumSum = new double[nums.length+1];
        for(int i=0; i < nums.length;i++){
            cumSum[i+1] = cumSum[i] + nums[i];
        }
        double max = Integer.MIN_VALUE;
        for(int i=0; i < cumSum.length-k; i++){
            
            max = Math.max((cumSum[i+k]-cumSum[i])/k,max);
        }
        return max;
        
    }
}
