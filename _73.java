import java.util.ArrayList;
import java.util.List;

class Solution {
    public void setZeroes(int[][] matrix) {
        List<Integer> rows = new ArrayList<Integer>();
        List<Integer> cols = new ArrayList<Integer>();
        for(int i=0; i < matrix.length; i++){
            for(int j=0; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        //clear up rows
        for(int i=0; i < rows.size(); i++){
            int x = rows.get(i);
            for(int j=0; j < matrix[0].length; j++){
                matrix[x][j] = 0;
            }
        }
        //clear up columns

        for(int i=0; i < cols.size(); i++){
            int x = cols.get(i);
            for(int j=0; j < matrix.length; j++){
                matrix[j][x] = 0;
            }
        }
    }
}
