class Solution {
    public int numDistinctIslands(int[][] grid) {
        
        Set<String> distinctIsland = new HashSet<String>();
         StringBuilder yo = null;
        for(int i=0; i < grid.length; i++){
            for(int j=0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                   yo = new StringBuilder();
                    yo.append("1#");
                    dfs(grid,i,j,yo,0);
                    distinctIsland.add(yo.toString());
                   // System.out.println(yo.toString());
                }
            }
        }
        return distinctIsland.size();
        
    }
    
    private void dfs(int[][] grid, int i, int j, StringBuilder island, int dir){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0){
            island.append("-1#");
            return;
        }
        grid[i][j] = 0;
        island.append(String.valueOf(dir)+"#");
        dfs(grid,i,j+1,island,0);
        dfs(grid,i+1,j,island,1);
        dfs(grid,i,j-1,island,2);
        dfs(grid,i-1,j,island,3);
        
        
    }
}
