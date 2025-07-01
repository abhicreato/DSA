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

class MaxSumSubArrayOfSizeK {

    static long maximumSumSubarray(int K, ArrayList<Integer> Arr, int N) {
        // code here
        int i = 0;
        int j = 0;
        long sum = 0;
        long max = Integer.MIN_VALUE;

        while (j < N) {

            sum = sum + Arr.get(j);

            if (j - i + 1 == K) {
                max = Math.max(max, sum);
                sum = sum - Arr.get(i);
                i++;
            }

            j++;

        }

        return max;
    }
}
