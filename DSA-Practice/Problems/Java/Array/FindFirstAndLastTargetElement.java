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
    
}
