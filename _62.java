/*
The solution relies on the dynamic programming approach of Recusrion with Memoization
Given the constraints that the robot can move only right or down, we can formulate the below recursion:
Let's say we have a function f 
that takes in start position of the robot (row and column) and returns the number
of ways to reach the destination.
We know that we can go either right or down. When we go right, we move one column forward.
When we go down, we move one row downwards.
So, if we start in a position (row,col), then the total number of ways to reach the destination will
be :
total ways to reach the destination from (row,col+1) 
+
total ways to reach the destination from (row+1,col)

Thus the recursion:
f(row,col) = f(row,col+1) + f(row+1,col);
To avoid computing subproblems again and again, a 2-D memoization array(M) is used where M[i][j] represents
the number of ways to reach the destination starting from row i and column j.
 */
class Solution {
    Integer[][] M;
    public int uniquePaths(int m, int n) {
        M = new Integer[m][n];
        return f(0,0,m,n);
    }

    private int f(int row, int col, int m, int n ){
        if(row >= m || col >= n){
            return 0;
        }
        if(row == m-1 && col == n-1){
            return 1;
        }
        if(M[row][col] == null){
            M[row][col] = f(row+1,col,m,n) + f(row,col+1,m,n);
        }
        return M[row][col];
    }
}
