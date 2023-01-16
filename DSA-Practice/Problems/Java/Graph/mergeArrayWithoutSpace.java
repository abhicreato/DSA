package Graph;

import java.util.Arrays;

public class mergeArrayWithoutSpace {
    
    //Function to merge the arrays.
    public static void merge(long arr1[], long arr2[], int n, int m) 
    {
        
        int i = n - 1;
        int j = 0;
        
        while(i>=0 && j < m){
            
            if(arr2[j] < arr1[i]){
                long temp = arr1[i];
                arr1[i] = arr2[j];
                arr2[j] = temp;
                j++;
            }else{
                i--;
            }
            
        }
        
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        
    }
}

/*
**************** Logic ****************
Since both the arrays are sorted, start i from the end of arr1 and j from start of arr2.
We want smaller elements in arr1 hence swap the elements if arr1[i] > arr2[j].
*/
