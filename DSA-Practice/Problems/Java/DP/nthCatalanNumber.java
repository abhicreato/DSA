package DP;

import java.math.BigInteger;

public class nthCatalanNumber {
    
    //Function to find the nth catalan number.
    public static BigInteger findCatalan(int n)
    {
        //Your code here
        if(n == 0 || n== 1) return BigInteger.ONE;
        
        BigInteger ANS[] = new BigInteger[n+1];
        ANS[0] = BigInteger.ONE;
        ANS[1] = BigInteger.ONE;
        
        for(int i = 2;i < n+1; i++){
            int x = i - 1;
            int y = 0;
            BigInteger temp = BigInteger.ZERO;
            while(x > -1 && y < i){
               temp = temp.add(ANS[y].multiply(ANS[x]));
               x--;
               y++;
            }
            ANS[i] = temp;
        }
        
        return ANS[n];
        
    }

}
