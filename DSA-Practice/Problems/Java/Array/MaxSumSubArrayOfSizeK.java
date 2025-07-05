/*
**************** Problem Description ****************
Given an array of integers Arr of size N and a number K.
Return the maximum sum of a subarray of size K.
    Example:
    Input:
    N = 4, K = 2
    Arr = [100, 200, 300, 400]
    Output:
    700
    Explanation:
    Arr3  + Arr4 =700,
    which is maximum.
*/

import java.util.*;

class Solution {
    public int maximumSumSubarray(int[] arr, int k) {

    int maxSum = Integer.MIN_VALUE;
    int sum = 0;
    
    int i=0;
    int j=0;
    
    while(j<arr.length){
        sum = sum + arr[j];
        if(j-i+1==k){
            maxSum = Math.max(maxSum,sum);
            sum = sum - arr[i];
            i++;
        }
        j++;
    }
    return maxSum;
    }
}
