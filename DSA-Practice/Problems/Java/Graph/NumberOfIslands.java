package Graph;

public class NumberOfIslands {

    int rows;
    int cols;
    public int numIslands(char[][] grid) {
        
        int numOfIslands = 0;
        rows = grid.length;
        cols = grid[0].length;
        
        for(int r = 0; r < rows; r++){
            for(int c = 0; c< cols; c++){
                if(grid[r][c] == '1') {
                    numOfIslands++;
                    findIslands(r,c,grid);
                }
            }
        }
        
        return numOfIslands;
      
    }
    
    public void findIslands(int r, int c, char[][] grid){
        
        if(r > rows - 1 || c > cols - 1 || r < 0 || c < 0 || grid[r][c] == '2' || grid[r][c] == '0') return;
        
        grid[r][c] = '2';
        
        findIslands(r - 1,c,grid);
        findIslands(r, c - 1,grid);
        findIslands(r + 1,c,grid);
        findIslands(r,c + 1,grid);
        
    }
}
