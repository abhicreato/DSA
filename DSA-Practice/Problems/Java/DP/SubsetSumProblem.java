package DP;

public class SubsetSumProblem {

    static boolean sumS [][];
    static int sumSi [][];

    static Boolean isSubsetSum(int N, int arr[], int sum){

        sumS = new boolean[N + 1][sum + 1];
        
        for(int i=0;i<N+1; i++){
            for(int j =0; j< sum + 1; j++){
                if(i == 0) sumS[i][j] = false;
                if(j == 0) sumS[i][j] = true;
            }
        }

        for(int i = 1 ; i < N + 1; i++){
            for(int j = 1 ; j < sum + 1; j++){
                if(arr[i - 1] <= j){
                    sumS[i][j] = sumS[i - 1][j - arr[i - 1]] || sumS[i - 1][j] ;
                }else{
                    sumS[i][j] = sumS[i - 1][j];
                }
            }
        }

        // Recursion method
        //solve(N,sum,arr);
        
        return sumS[N][sum];
        
    }
    
    // Recursion with momoization
    static boolean solve(int i, int sum, int [] arr){
        
        if(sum == 0) return true;
        
        if(i == 0){
            return sum == 0;
        }

        // memoization step here

        if(sum >= arr[i - 1]){
            return sumS[i][sum] = solve(i - 1, sum - arr[i - 1], arr) || solve(i - 1, sum, arr);
        }else{
            return sumS[i][sum] = solve(i - 1, sum, arr);
        }
        
    }
    


    
}
