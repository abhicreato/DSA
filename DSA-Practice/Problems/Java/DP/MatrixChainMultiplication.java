package DP;

public class MatrixChainMultiplication {

    static int ans;
    
    static int matrixMultiplication(int N, int arr[])
    {
        // code here
        return solve(arr, 1, N - 1);
    }
    
    static int solve(int[] arr, int i, int j){
        
        if(i >= j) return 0;
        
        int min = Integer.MAX_VALUE;
        
        for(int k = i ; k <= j-1; k++){
            
            int temp = solve(arr, i, k) + solve(arr, k + 1, j) + (arr[i-1] * arr[k] * arr[j]);
             
            min = Math.min(min, temp); 
            
        }
        
        return min;
        
    }
    
}
