class Solution {
    int[] original;
    Random random;
    public Solution(int[] nums) {
        original = nums;
        random = new Random();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return original;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        List<Integer> temp = new ArrayList<Integer>();
        int[] result = new int[original.length];
        for(int i=0; i < original.length; i++){
            temp.add(original[i]);
        }
        
        for(int i=0; i < original.length; i++){
            int k = random.nextInt(temp.size());
            result[i] = temp.get(k);
            temp.remove(k);
        }
        return result;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
