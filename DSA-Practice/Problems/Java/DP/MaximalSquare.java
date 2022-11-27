package DP;

public class MaximalSquare {
    int dp[][];
    int maximalSquareSize;
    public int maximalSquare(char[][] matrix) {
        
        int r = matrix.length;
        int c = matrix[0].length;
        
        dp = new int[r][c];
        
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                dp[i][j] = -1;
            }
        }
        
        solve(matrix,0,0);
        
        //return (int) Math.pow(maximalSquareSize, 2);
        return maximalSquareSize * maximalSquareSize;
    }
    
    public int solve(char[][] mat, int m, int n){
        
        if(m >= mat.length || n >= mat[0].length) return 0;

        if(dp[m][n] != -1) return dp[m][n];
        
        int right = solve(mat, m, n + 1);
        int diagonal = solve(mat, m + 1, n + 1);
        int down = solve(mat, m + 1, n);
        
        if(mat[m][n] == '1'){
            dp[m][n] = 1 + Math.min(right, Math.min(diagonal, down));
            maximalSquareSize = Math.max(maximalSquareSize, dp[m][n]);
            return dp[m][n];
        }else{
            return dp[m][n] = 0;
        }
         
    }
}
