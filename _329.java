/*
The idea in this solution is to first create a 2-D memoization array and then set the value at the 
positions (i,j) to be 1 (M[i][j] = 1) when we cannot move in any direction from there. These will serve
as our end points.
Now traverse the array in all four directions following any approach (dfs or bfs) considering each non-1 (i,j) location as start point. Memoize the maximum value you obtain.
At the end, the maximum will be the answer.
*/
class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0){
            return 0;
        } 
        if(matrix.length == 1 && matrix[0].length == 1){
            return 1;
        }
         Integer[][] M = new Integer[matrix.length][matrix[0].length];
        if(matrix.length == 1){
           for(int j=0; j < matrix[0].length; j++){
            //top row
               if(j == 0){
                   if(matrix[0][j] >= matrix[0][j+1]){
                        M[0][j] = 1;
                    }
               }else if(j == matrix[0].length - 1){
                    if(matrix[0][j] >= matrix[0][j-1]){
                        M[0][j] = 1;
                    }
               }else{
                   if(matrix[0][j] >= matrix[0][j+1] && matrix[0][j] >= matrix[0][j-1]){
                        M[0][j] = 1;
                    } 
               }
           } 
        }else if(matrix[0].length == 1){
            for(int i=0; i < matrix.length; i++){
                if(i == 0){
                    if(matrix[i][0] >= matrix[i+1][0]){
                        M[i][0] = 1;
                    }
                }else if(i == matrix.length-1){
                     if(matrix[i][0] >= matrix[i-1][0]){
                        M[i][0] = 1;
                    }
                }else{
                    if(matrix[i][0] >= matrix[i-1][0] && matrix[i][0] >= matrix[i+1][0]){
                        M[i][0] = 1;
                    }
                }
            }
        }else{
       
        
           for(int j=0; j < matrix[0].length; j++){
            //top row
               if(j == 0){
                   if(matrix[0][j] >= matrix[0][j+1] && matrix[0][j] >= matrix[1][j]){
                        M[0][j] = 1;
                    }
               }else if(j == matrix[0].length - 1){
                    if(matrix[0][j] >= matrix[0][j-1] && matrix[0][j] >= matrix[1][j]){
                        M[0][j] = 1;
                    }
               }else{
                   if(matrix[0][j] >= matrix[0][j+1] && matrix[0][j] >= matrix[1][j] && matrix[0][j] >= matrix[0][j-1]){
                        M[0][j] = 1;
                    } 
               }
           }
        //leftmost column
            for(int i=0; i < matrix.length; i++){
                if(i == 0){
                    if(matrix[i][0] >= matrix[i+1][0] && matrix[i][0] >= matrix[i][1]){
                        M[i][0] = 1;
                    }
                }else if(i == matrix.length-1){
                     if(matrix[i][0] >= matrix[i-1][0] && matrix[i][0] >= matrix[i][1]){
                        M[i][0] = 1;
                    }
                }else{
                    if(matrix[i][0] >= matrix[i-1][0] && matrix[i][0] >= matrix[i][1] && matrix[i][0] >= matrix[i+1][0]){
                        M[i][0] = 1;
                    }
                }
            }
        //bottmomost row
         for(int j=0; j < matrix[0].length; j++){
            
               if(j == 0){
                   if(matrix[matrix.length-1][j] >= matrix[matrix.length-1][j+1] && matrix[matrix.length-1][j] >= matrix[matrix.length-1-1][j]){
                        M[matrix.length-1][j] = 1;
                    }
               }else if(j == matrix[0].length - 1){
                    if(matrix[matrix.length-1][j] >= matrix[matrix.length-1][j-1] && matrix[matrix.length-1][j] >= matrix[matrix.length-1-1][j]){
                        M[matrix.length-1][j] = 1;
                    }
               }else{
                   if(matrix[matrix.length-1][j] >= matrix[matrix.length-1][j+1] && matrix[matrix.length-1][j] >= matrix[matrix.length-1-1][j] && matrix[matrix.length-1][j] >= matrix[matrix.length-1][j-1]){
                        M[matrix.length-1][j] = 1;
                    } 
               }
           }
        
        //rightmost column
        for(int i=0; i < matrix.length; i++){
                if(i == 0){
                    if(matrix[i][matrix[0].length - 1] >= matrix[i+1][matrix[0].length - 1] && matrix[i][matrix[0].length - 1] >= matrix[i][matrix[0].length - 1-1]){
                        M[i][matrix[0].length - 1] = 1;
                    }
                }else if(i == matrix.length-1){
                     if(matrix[i][matrix[0].length - 1] >= matrix[i-1][matrix[0].length - 1] && matrix[i][matrix[0].length - 1] >= matrix[i][matrix[0].length - 1-1]){
                        M[i][matrix[0].length - 1] = 1;
                    }
                }else{
                    if(matrix[i][matrix[0].length - 1] >= matrix[i-1][matrix[0].length - 1] && matrix[i][matrix[0].length - 1] >= matrix[i][matrix[0].length - 1-1] && matrix[i][matrix[0].length - 1] >= matrix[i+1][matrix[0].length - 1]){
                        M[i][matrix[0].length - 1] = 1;
                    }
                }
            }
        
        
        }
        for(int i=1; i < matrix.length-1; i++){
            for(int j=1; j < matrix[0].length-1; j++){
                
                if(matrix[i][j] >= matrix[i][j+1] && matrix[i][j] >= matrix[i-1][j] && matrix[i][j] >= matrix[i+1][j] && matrix[i][j] >= matrix[i][j-1]){
                    M[i][j] = 1;
                }
            }
        }
        /*
        for(int i=0; i < M.length; i++){
            for(int j=0; j < M[0].length; j++){
                System.out.print(M[i][j] + " ");
            }
            System.out.println();
        }
        */
        int[] result = new int[1];
        result[0] = Integer.MIN_VALUE;
        for(int i=0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                result[0] = Math.max(result[0],dfs(matrix,i,j,M,result));
            }
        }
        /*
        for(int i=0; i < M.length; i++){
            for(int j=0; j < M[0].length; j++){
                System.out.print(M[i][j] + " ");
            }
            System.out.println();
        }
        */
        return result[0];
        
        
        
        
        
    }
    
    private int dfs(int[][] grid, int i, int j, Integer[][] M, int[] result){
        if(i >= grid.length || i < 0 || j >= grid[0].length || j < 0 ){
            return 0;
        }
        if(M[i][j] == null){
            int x = 1;
            if(j+1 < grid[0].length && grid[i][j] < grid[i][j+1]){
                x = 1 + dfs(grid,i,j+1,M,result);
            }
            M[i][j] = x;
            if(i+1 < grid.length && grid[i][j] < grid[i+1][j]){
                x = 1 + dfs(grid,i+1,j,M,result);
            }
            M[i][j] = Math.max(M[i][j],x);
            if(i-1 >= 0 && grid[i][j] < grid[i-1][j]){
                x = 1 + dfs(grid,i-1,j,M,result);
            }
            M[i][j] = Math.max(M[i][j],x);
            if(j-1 >= 0 && grid[i][j] < grid[i][j-1]){
                x = 1 + dfs(grid,i,j-1,M,result);
            }
            
            M[i][j] = Math.max(M[i][j],x);
        }
        return M[i][j];
    }
}
