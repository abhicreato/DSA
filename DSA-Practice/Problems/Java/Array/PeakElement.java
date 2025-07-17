public class PeakElement {
    class Solution {

        public int findPeakElement(int[] nums) {
            int n = nums.length;

            // Handle edge cases directly
            if (n == 1 || nums[0] > nums[1])
                return 0;
            if (nums[n - 1] > nums[n - 2])
                return n - 1;

            int left = 1, right = n - 2;

            while (left <= right) {
                int mid = left + (right - left) / 2;

                if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                    return mid;
                } else if (nums[mid] < nums[mid + 1]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            // Fallback (should not reach here)
            return -1;
        }

        public int findPeakElement2(int[] nums) {
            int l = nums.length;
            int start = 1;
            int end = nums.length - 2;

            if (l == 1)
                return 0;

            while (start <= end) {
                int mid = (start + end) / 2;

                if (nums[mid - 1] < nums[mid] && nums[mid] > nums[mid + 1]) {
                    return mid;
                } else if (nums[mid + 1] > nums[mid]) {
                    start = mid + 1;
                } else if (nums[mid - 1] > nums[mid]) {
                    end = mid - 1;
                }

            }

            if (nums[0] > nums[1])
                return 0;

            return l - 1;

        }
    }
}


// think it as progression increasing order or decreing order 