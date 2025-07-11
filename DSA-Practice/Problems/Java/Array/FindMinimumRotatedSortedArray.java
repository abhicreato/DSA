public class FindMinimumRotatedSortedArray {

    public int findMin(int[] nums) {
    
        int l = nums.length;
        int start = 0;
        int end = l - 1;
        
        while (start <= end) {
            if (nums[start] <= nums[end]) return nums[start];
            
            int mid = (start + end) / 2;
            
            if (nums[mid] >= nums[start]) start = mid + 1;
            else end = mid;
        }
        
        return nums[start];
    }

     public int findMin2(int[] nums) {

        int start = 0;
        int end = nums.length - 1;
        int op = nums[0];

        while(start<=end){

            if(nums[start] < nums[end]) return Math.min(op, nums[start]);

            int mid = (start + end ) / 2;

            op = Math.min(op, nums[mid]);

            if(nums[start] <= nums[mid]){
                start = mid + 1;
            }else{
                end = mid - 1;
            }

        }

        return op;
    }
    
}


/*
**************** Logic ****************
Looking at subarray with index [start,end]. We can find out that if the first member is less than the last member, there's no rotation in the array.
So we could directly return the first element in this subarray.
If the first element is larger than the last one, then we compute the element in the middle, and compare it with the first element.
If value of the element in the middle is larger than the first element, we know the rotation is at the second half of this array. Else, it is in the first half in the array.
*/
