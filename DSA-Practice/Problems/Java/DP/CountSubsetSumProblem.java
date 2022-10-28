public class CountSubsetSum {
    
    
    static int count = 0;
    public static int findWays(int num[], int tar) {
        // Write your code here..
        int n = num.length;
        int count = 0;
        
        boolean dp[][] = new boolean[n+1][tar + 1];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==0) dp[i][j] = false;
                if(j==0) dp[i][j] = true;
            }
        }
        
        for(int i=1;i<n;i++){
            for(int j=1;j<n;j++){
                if(j == tar) count++;
                
                 if(num[i - 1] <= tar){
                    dp[i][j] = dp[i-1][j - num[i -1]] || dp[i - 1][j];
                 }else{
                    dp[i][j] = dp[i - 1][j];
                 }
            }
        }
        
        if(dp[n][tar]){
            return count;
        }
        return 0;
    }
    
    public static boolean solve(int index, int [] num, int tar){
        
        if(index < 0) return false;

        if(tar == 0){
            count++;
            return true;
        } 
        
        if(num[index - 1] <= tar){
            
            boolean taken = solve(index - 1, num, tar - num[index - 1]);
            boolean notTaken = solve(index - 1, num, tar);
            
            return taken || notTaken;
            
        }else{
            return solve(index - 1, num, tar);
        }
        
    }
}
