package DP;

public class LongestIncreasingSubsequence {

    int dp[][];
    int dp2[];
    public int lengthOfLIS(int[] nums) {

        int l = nums.length;

        if(l == 1 && nums[0] == 0) return 1;
  
        // Memoization 
        // dp = new int [l+1][l+1];

        // for(int i=0;i<=l;i++){
        //     for(int j=0;j<=l;j++){
        //         dp[i][j] = -1;
        //     }
        // }

        // // Add a min value at index 0 and shift values to accomodate prev index
        // int input[] = new int[l+1];
        // input[0] = Integer.MIN_VALUE;
        // for(int i=1;i<=l;i++){
        //     input[i] = nums[i-1];
        // }

        // Tabulation 
        // https://www.youtube.com/watch?v=odrfUCS9sQk&t=1388s
        dp2 = new int[l];
        dp2[0] = 1;
        int ans = 0;

        for(int i = 1; i < l; i++){

            int max = 0;

            for(int j = 0; j < i ; j++){
                if(nums[j] < nums[i]){
                    max = Math.max(max, dp2[j]);
                }
            }

            dp2[i] = max + 1;
            ans = Math.max(ans, dp2[i]);

        }

        return ans;
        
        //return solve(input, 0, 0);
    }

    public int solve(int[] nums, int currIndex, int prevPickIndex){

        if(currIndex == nums.length) return 0;

        if(dp[currIndex][prevPickIndex] != -1) return dp[currIndex][prevPickIndex];

        int lenIfNotTaken = solve(nums, currIndex + 1, prevPickIndex);

        int lenIfTaken = 0;
        if(nums[prevPickIndex] < nums[currIndex]){
            lenIfTaken = 1 + solve(nums, currIndex + 1, currIndex);
        }

        return dp[currIndex][prevPickIndex] = Math.max(lenIfNotTaken, lenIfTaken);
    }
}
