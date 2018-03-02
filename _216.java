class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> elements = new HashSet<Integer>();
        Set<Integer> visited = new HashSet<Integer>();
        for(int num : nums){
            elements.add(num);
        }
        int max = 0;
        int currMax = 1;
        int[] interval = new int[2];
        for(int i=0; i < nums.length; i++){
            int curr = nums[i];
            interval[0] = curr;
            while(elements.contains(interval[0]-1) && !visited.contains(interval[0]-1)){
                visited.add(interval[0]-1);
                interval[0] = interval[0]-1;
                
            }
            interval[1] = curr;
            while(elements.contains(interval[1]+1) && !visited.contains(interval[1]+1)){
                visited.add(interval[1]+1);
                interval[1] = interval[1]+1;
                
            }
            max = Math.max(max,interval[1]-interval[0]+1);
        }
        return max;
    }
}
