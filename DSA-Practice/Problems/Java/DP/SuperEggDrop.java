package DP;

public class SuperEggDrop {
    int [][] dp;
    public int superEggDrop(int k, int n) {
        dp = new int [k+1][n+1];
        for(int i=0;i<=k;i++){
            for(int j=0;j<=n;j++){
                dp[i][j] = -1;
            }
        }
        return solve(k,n);
    }

    public int solve(int eggs, int floors){

        if(floors == 0 || floors == 1) return floors;

        if(eggs == 1) return floors;

        if(dp[eggs][floors] != -1) return dp[eggs][floors];

        int min = Integer.MAX_VALUE;
        int l = 1;
        int r = floors;
        int worstCaseAns = 0;

        // Optimization With binaray search approch
        while(l<=r){
            int k = (l+r)/2;

            int eggBreak = (dp[eggs-1][k-1] != -1) ? dp[eggs-1][k-1] : solve(eggs - 1, k - 1);
            int eggDntBreak = (dp[eggs][floors - k] != -1) ? dp[eggs][floors - k] : solve(eggs,floors - k);

            worstCaseAns = 1 + Math.max(eggBreak, eggDntBreak);

            if(eggBreak<eggDntBreak){        //  since right is more than left and we need more in worst case 
                l=k+1;                       //  so l=mid+1 to gain more temp for worst case : upward
            }else{    
                r=k-1;
            }

            min = Math.min(min, worstCaseAns);

        }

        // By checking all floors linear way 
        // for(int k = 1; k<=floors; k++){

        //     int eggBreak = (dp[eggs-1][k-1] != -1) ? dp[eggs-1][k-1] : solve(eggs - 1, k - 1);
        //     int eggDntBreak = (dp[eggs][floors - k] != -1) ? dp[eggs][floors - k] : solve(eggs,floors - k);

        //     int worstCaseAns = 1 + Math.max(eggBreak, eggDntBreak);

        //     min = Math.min(min, worstCaseAns);
        // }

        return dp[eggs][floors] = min;

    }
}
