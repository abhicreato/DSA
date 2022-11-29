package DP;

/*
**************** Problem Description ****************
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.
Note: You can only move either down or right at any point in time.
    Example : 1
        
    Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
    Output: 7
    Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
    Example : 2
    
    Input: grid = [[1,2,3],[4,5,6]]
    Output: 12
*/


public class MinimumPathSum {

    int dp[][];
    public int minPathSum(int[][] grid) {
        
        int rows = grid.length;
        int cols = grid[0].length;
        
        dp = new int [rows][cols];
        return solve(grid,0,0);
    }
    
    public int solve(int[][] grid, int i, int j){
        
        int rows = grid.length;
        int cols = grid[0].length;
        
        if(i == rows - 1 && j == cols - 1) return grid[i][j];
        
        if(dp[i][j] != 0) return dp[i][j];
        
        int right = Integer.MAX_VALUE - 1;
        int down = Integer.MAX_VALUE - 1;
        
        if(j + 1 < cols){
            right = solve(grid, i, j + 1);
        }
        
        if(i + 1 < rows){
            down = solve(grid, i + 1, j);
        }
        
        return dp[i][j] = grid[i][j] + Math.min(right, down);
        
    }
    
}

/*
**************** Logic ****************
We have 2 choices, we can go right or bottom.
Calculate minimum path sum for both choices and choose minimum.
Both choices have overlapping sub problems, hence store the result in dp.
*/
