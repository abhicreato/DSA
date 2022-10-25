package DP;

class KnapSack {

    static int cost[][];
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
         
        cost = new int[n + 1][W + 1];
        
        for(int i=0;i<cost.length;i++){
            for(int j =0;j < cost[i].length;j++)
            cost[i][j] = -1;
        }
        
        return solve(W,wt,val,n);

    } 
    
    static int solve(int W, int[] wt, int val[], int n){
        
        if(n == 0 || W == 0) return 0;
        
        if(cost[n][W] != -1) return cost[n][W];
        
        if(W >= wt[n - 1]){
            return cost[n][W] = Math.max((val[n - 1] + solve(W - wt[n - 1], wt, val, n - 1)), solve(W, wt, val, n - 1));
        }else{
            return cost[n][W] = solve(W, wt, val, n - 1);
        }
        
        
    }
}

class knapSack2{
     
    static int cost[][];
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
         
        cost = new int[n + 1][W + 1];
        
        // Iterative soln 
        for(int i=0;i<cost.length;i++){
            for(int j =0;j < cost[i].length;j++)
            if(i == 0 || j == 0) cost[i][j] = 0; 
            
        }
        
        for(int i = 1; i < n + 1; i++){
            for(int j = 1; j < W + 1; j++){
                if(j >= wt[i - 1]){
                    cost[i][j] = Math.max(val[i - 1] + cost[i - 1][j - wt[i - 1]], cost[i - 1][j]);
                }else{
                    cost[i][j] = cost[i - 1][j];
                }
            }
        } 
        
        return cost[n][W];

    } 

}
