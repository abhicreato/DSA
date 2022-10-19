package Graph;

public class FloydWarshallAlgo {
    public void shortest_distance(int[][] matrix)
    {

        // Code here 
        int vertex = matrix.length;

        // for(int i=0;i<vertex;i++){
        //     for( int j = 0; j<vertex; j++){
        //         if(matrix[i][j] == -1) matrix[i][j] = 9999;
        //     }
        // }
        
        for(int k = 0 ; k < vertex ; k++){
            for(int i = 0; i < vertex ; i++){
                for(int j = 0; j < vertex ; j++){
                    
                    if(matrix[i][k] == -1 || matrix[k][j] == -1) continue; 
                    
                    matrix[i][j] = (matrix[i][j] == -1) ? matrix[i][k] + matrix[k][j] : Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                    
 
                }
            }
        }
        
        // for(int i=0;i<vertex;i++){
        //     for( int j = 0; j<vertex; j++){
        //         if(matrix[i][j] == 9999) matrix[i][j] = -1;
        //     }
        // }
    }
}
