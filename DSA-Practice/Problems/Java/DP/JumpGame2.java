package DP;

public class JumpGame2 {

    int dp[];
    public int jump(int[] nums) {
        
        dp = new int[nums.length];
        for(int i=0;i<nums.length;i++) dp[i] = -1;
        
        return solve(nums, 0);
        
    }
    
    
    public int solve(int[] nums, int currIndex){
        
        if(currIndex >= nums.length - 1) return 0;
        
        if(dp[currIndex] != -1) return dp[currIndex];
        
        int ans = Integer.MAX_VALUE - 1;
        for(int i = 1; i<=nums[currIndex]; i++){
            int jumps = 1 + solve(nums, currIndex + i);
            ans = Math.min(ans, jumps);
        }
        
        return dp[currIndex] = ans;
        
    }
    
}
