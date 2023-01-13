public class FindDuplicateNumber {

    public int findDuplicate(int[] nums) {
        
        int s = 1;
        int e = nums.length - 1;
        
        while(s<e){
            
            int mid = (s+e)/2;
            
            int count = 0;
            for(int i : nums){
                if(i<=mid) count++;
            }
            
            if(count > mid) e = mid;
            else s = mid + 1;
            
        }
        
        return s;
        
    }
    
}


/*
**************** Logic ****************
At first the search space is numbers between 1 to n.
Each time we select a number mid (which is the one in the middle) and count all the numbers equal to or less than mid.
If the count is more than mid, the search space will be [1 to mid] otherwise [mid+1 to n]. I do this until search space is only one number.
Let's say n=10 and I select mid=5. Then I count all the numbers in the array which are less than equal mid.
If the there are more than 5 numbers that are less than or equal to 5, then by Pigeonhole Principle, one of them has occurred more than once.
So I shrink the search space from [1 to 10] to [1 to 5]. Otherwise the duplicate number is in the second half so for the next step the search space would be [6 to 10].
*/
