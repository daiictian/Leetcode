class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        Arrays.fill(color,-1);
        
        for(int i=0; i < graph.length; i++){
            if(color[i] == -1){
                
                Stack<Integer> st = new Stack<Integer>();
                st.push(i);
                color[i] = 0;
                while(!st.isEmpty()){
                    int x = st.pop();
                    for(int num : graph[x]){
                        if(color[num] == -1){
                            color[num] = color[x]^1;
                            st.push(num);
                        }else{
                            if(color[num] == color[x]) return false;
                        }
                    }
                }
                
            }
        }
        return true;
        
    }
}
