package DP;

import java.util.*;

public class ScrambleString {

    Map<String,Boolean> dp = new HashMap<>();

    public boolean isScramble(String a, String b) {

        if(a.equals(b) == true) return true;
        
        if(a.length() != b.length()) return false;
        
        if(a.isEmpty() == true) return true;
        
        return solve(a, b);

    }

    public boolean solve( String a, String b){

        if(a.equals(b) == true) return true;

        String key = a + "@" + b;

        if(dp.containsKey(key)) return dp.get(key);

        int n = a.length();
        boolean check = false;

        // More Optimization 
        // If count of alphabets is not equal in both strings then we cannot scramble
        int[] letters = new int[26];
        for (int i=0; i<a.length(); i++) {
            letters[a.charAt(i) - 'a']++;
            letters[b.charAt(i) - 'a']--;
        }
        for (int i=0; i<26; i++){
            if (letters[i]!=0){
                dp.put(key,false);
                return false;
            } 
        } 

        for(int k = 1; k < n; k++){

            boolean swapCase = (isScramble(a.substring(0, k), b.substring(n - k)) && isScramble(a.substring(k), b.substring(0, n - k)));
            boolean unSwapCase = (isScramble(a.substring(0, k), b.substring(0, k)) && isScramble(a.substring(k), b.substring(k)));

             if(swapCase || unSwapCase){
                check = true;
                break;
            }

        }

        dp.put(key,check);

        return check;
    }

}
