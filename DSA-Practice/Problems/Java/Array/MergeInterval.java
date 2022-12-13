import java.util.*;
public class MergeInterval {

    
    public int[][] merge(int[][] intr) {

        int row = intr.length;
        int [][] ans = new int[row][2];
        
        for(int []pair :ans){
            Arrays.fill(pair,-1);
        }
        
        Arrays.sort(intr, Comparator.comparingInt(o -> o[0]));
        ans[0] = intr[0];
        
        int i = 0;
        for(int j = 1; j < row; j++){
            
            if(intr[j][0] <= ans[i][1]){
                ans[i][1] = Math.max(intr[j][1], ans[i][1]);
            }else{
                ans[++i] = intr[j];
            }
            
        }
        
        int length = 0;
        for(int pair[] :ans){
            if(pair[0] != -1) length++;
        }
        
        int [][] op = new int[length][2];
        
        for(int j=0;j<length;j++){
            op[j] = ans[j];
        }
        
        return op;
        
    }
    
}
