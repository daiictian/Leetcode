class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] temp = new int[length+1];
        
        for(int[] yo : updates){
            temp[yo[0]] += yo[2];
            temp[yo[1]+1] -= yo[2];
        }
        
        System.out.println();
        int[] result = new int[length];
        result[0] = temp[0];
        for(int i=1; i< result.length; i++){
            result[i] += result[i-1]+temp[i];
        }
        return result;
        
    }
}
