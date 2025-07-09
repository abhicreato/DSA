public class FindFirstAndLastTargetElement {

    
    public int[] searchRange(int[] nums, int target) {
        
        int ans[] = {-1,-1};
        
        ans[0] = findFirstIndex(nums, 0, nums.length - 1, target);
        ans[1] = findLastIndex(nums, 0, nums.length - 1, target);
        
        return ans;
    
        
    }
    
    public int findFirstIndex(int[] num, int start, int end, int target){
        
        int index = -1;
        int mid = 0;
        
        while(start <= end){
            
            mid = (start + end)/2;
            
            if(num[mid] == target) index = mid;
            
            if(target <= num[mid]){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
            
        }
        return index;
    }
    
    public int findLastIndex(int[] num, int start, int end ,int target){
        int index = -1;
        int mid = 0;
        
        while(start <= end){
            
            mid = (start + end)/2;
            
            if(num[mid] == target) index = mid;
            
            if(target >= num[mid]){
                start = mid + 1;
            }else{
               end = mid - 1;
            }
            
        }
        
        return index;
        
    }
    
    public int[] searchRange2(int[] nums, int target) {
    int i = 0;
    int j = nums.length - 1;
    int[] op = { -1, -1 };

    while (i <= j) {
        int n = (i + j) / 2;

        if (nums[n] == target) {
            int left = n, right = n;
            // Expand left
            while (left > 0 && nums[left - 1] == target) left--;
            // Expand right
            while (right < nums.length - 1 && nums[right + 1] == target) right++;
            op[0] = left;
            op[1] = right;
            return op;
        } else if (nums[n] < target) {
            i = n + 1;
        } else {
            j = n - 1;
        }
    }

    return op;
}
}
