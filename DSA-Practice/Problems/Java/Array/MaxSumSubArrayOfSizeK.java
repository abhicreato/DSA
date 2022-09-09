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

class MaxSumSubArrayOfSizeK {
    public static void main(String[] args) {
        System.out.println("MaxSumSubArrayOfSizeK");
    }

    public static int MaxSumSubArrayOfSizeK(int[] nums, int k){
        int i = 0;
        int j=0;
        int sum=0;
        int max = 0;

        while(j<arr.length){
            sum = sum + nums[j];
            if(j-i+1 <k){
                j++;
            }else if(j-i+1 == k){
                max = Math.max(max, sum);
                sum = sum - nums[i];
                i++;
                j++;
            }
        }
        return max;
    }
}