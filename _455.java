class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        int left = 0;
        int index = 0;
        while(left < g.length && index < s.length){
            if(s[index] >= g[left]){
                count++;
                index++;
                left++;
            }else{
                index++;
            }
        }
        return count;
    }
}
