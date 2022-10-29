package DP;

public class TargetSum {

    public int findTargetSumWays(int[] nums, int target) {
    
        int n = nums.length;
        
        // Edge cases
        if(n == 1){
            if(nums[0] == Math.abs(target))
                return 1;
            else
                return 0;
        }

        int sum =0;

        for(int i : nums){
            sum+=i;
        }
        
        if(((sum + target) % 2 == 1) || (target > sum)) // if sum is not even Or taget > sum
        return 0;
        
        target = (target + sum)/2;
        
        int dp[][] = new int[n+1][target+1];
        
        for(int i=0;i<=n;i++){
            for(int j =0;j<=target;j++){
                if(i==0) dp[i][j] = 0;
                if(j==0) dp[i][j] = 1;
            }
        }
        
        for(int i=1;i<=n;i++){
            for(int j=0;j<=target;j++){
                
                if(j >= nums[i-1]){
                    dp[i][j] = dp[i-1][j-nums[i-1]] + dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
                
            }
        }
        
        return dp[n][target];
        
    }
    
}
