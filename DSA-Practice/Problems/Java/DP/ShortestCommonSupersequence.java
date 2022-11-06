package DP;

public class ShortestCommonSupersequence {

    public String shortestCommonSupersequence(String str1, String str2) {

        StringBuilder ans = new StringBuilder();
        int l1 = str1.length();
        int l2 = str2.length();
        int dp[][] = new int[l1+1][l2+1];

        for(int i=0;i<=l1;i++){
            for(int j=0;j<=l2;j++){
                if(i==0||j==0) dp[i][j] = 0;
            }
        }

        for(int i=1;i<=l1;i++){
            for(int j=1;j<=l2;j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }

        int i = l1;
        int j = l2;

        while(i>0 && j>0){
            if(str1.charAt(i-1) == str2.charAt(j-1)){
                ans.append(str1.charAt(i-1));
                i--;
                j--;
            }else{
                if(dp[i-1][j] > dp[i][j-1]){
                    ans.append(str1.charAt(i-1));
                    i--;
                }else{
                    ans.append(str2.charAt(j-1));
                    j--;
                }
            }
        }

        while(i>0){
            ans.append(str1.charAt(i-1));
            i--;
        }
        
        while(j>0){
            ans.append(str2.charAt(j-1));
            j--;
        }

        return ans.reverse().toString();

    }
    
}
