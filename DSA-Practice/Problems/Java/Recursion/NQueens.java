package Recursion;

/*
 * 51. N-Queens
Hard

8356

189

Add to List

Share
The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.

 

Example 1:


Input: n = 4
Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above
Example 2:

Input: n = 1
Output: [["Q"]]
 */

import java.util.*;

public class NQueens {

    List<List<String>> ans = new ArrayList();
    char[][] board;
    
    public List<List<String>> solveNQueens(int n) {
    
        // blank board
        board = new char[n][n];

        // Fill each row with .
        for (char[] row : board)
            Arrays.fill(row, '.');
        
        solve(0,n);
        
        return ans;
    }
    
    public void solve(int col, int n){
        
        if(col == n){
            List<String> listOfStr = new ArrayList();
            
            for (char[] row : board){
                listOfStr.add(new String(row));
            }
              
            this.ans.add(listOfStr);
            return;
        }
        
        for(int row = 0; row < n; row++){
            if(isSafe(row,col,n)){
                board[row][col] = 'Q';
                solve(col + 1, n);
                board[row][col] = '.';
            } 
        }
        
    }
    
    public boolean isSafe(int row,int col,int n){
        
        int row1 = row;
        int col1 = col;
        
        //Check Upper digonal
        while(row>=0 && col>=0){
            if( board[row][col] == 'Q'){
                return false;
            }
            row--;
            col--;
        }
        
        //Check on left 
        row = row1;
        col = col1;
        while(col>=0){
            if(board[row][col] == 'Q'){
                return false;
            }
           col--; 
        }
        
        //Check on lower digonal 
        row = row1;
        col = col1;
        while(col >= 0 && row < n){
            if(board[row][col] == 'Q'){
                return false;
            }
            col--;
            row++;
        }
        
        return true;
        
    }
    
}
