package Graph;

public class FloodFill {

    int row;
    int col;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        row = image.length;
        col = image[0].length;
        solve(image, sr, sc, color, image[sr][sc]);
            
        return image;
        
    }
    
    public void solve(int[][] image, int sr, int sc, int color, int srcClr){
        
        if(!(sr < row && sc < col && sr > -1 && sc > -1) 
        || image[sr][sc] != srcClr 
        || srcClr == color) return;
        
        image[sr][sc] = color;
       
        solve(image,sr + 1, sc, color, srcClr);
        solve(image,sr, sc + 1, color, srcClr);
        solve(image, sr - 1, sc, color, srcClr);
        solve(image, sr, sc - 1, color, srcClr);
 
    }

}
