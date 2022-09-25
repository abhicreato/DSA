package Recursion;

import java.util.*;

public class LargestNumberInKSwap {
    
//Function to find the largest number after k swaps.
public String ans = new String();
public String findMaximumNum(String str, int k){
        
    solve(str,k,0);
    
    return ans;
    
}
    
public void solve(String ip, int swaps ,int index){

    if(swaps == 0 || index == ip.length()){
        return;
    }
    
    // Find the max number to the right (1,2,3,4,5,6,7) = maxC = 7
    int n = ip.length();
    char maxC = ip.charAt(index);
    for(int i = index + 1; i < n; i++){
        if(ip.charAt(i) > maxC){
            maxC = ip.charAt(i);
        } 
    }
    
    // Ignore self swap (1,2,3) swap 1 to 1 can be ignored as it will not change anything
    if(maxC != ip.charAt(index)){
       swaps--; 
    } 
    
    // Recursively find all posible numbers and update max
    for(int i = index; i < n; i++){

        if(ip.charAt(i) == maxC){
        
        ip = swap(ip, index, i);
        
        if(ip.compareTo(ans) > 0){
            ans = ip;
        }
        
        solve(ip, swaps, index + 1);
        ip = swap(ip, index, i); 
        
        }
    }
    
}
    
public static String swap(String ip,int i,int j){
    
    StringBuilder sb = new StringBuilder(ip);
    
    sb.setCharAt(i, ip.charAt(j));
    sb.setCharAt(j, ip.charAt(i));
    
    return sb.toString();
}

}
