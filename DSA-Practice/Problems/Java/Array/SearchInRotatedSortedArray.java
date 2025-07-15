
public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {

        int l = nums.length;

        // Find minimun in rotated sorted array
        int minIdx = findMin(nums, l);

        if (nums[minIdx] == target) {
            return minIdx;
        }

        // consider min value as pivot and search on both side
        int left = binarySearch(nums, 0, minIdx - 1, target);
        int right = binarySearch(nums, minIdx, l - 1, target);

        // return the index of left or right side
        if (left != -1) {
            return left;
        }
        if (right != -1) {
            return right;
        }

        // if not present on both side means not present return -1
        return -1;

    }

    public int search2(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid = 0;
        while (start <= end) {
            mid = (start + end) / 2;
            if (nums[mid] == target)
                return mid;
            if (nums[mid] <= nums[end]) {
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                if (target > nums[mid] || target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        return -1;
    }

    int binarySearch(int arr[], int s, int e, int key) {

        while (s <= e) {

            int mid = (s + e) / 2;

            if (arr[mid] == key) {
                return mid;
            }

            if (arr[mid] > key)
                e = mid - 1;
            else
                s = mid + 1;
        }

        return -1;
    }

    int findMin(int nums[], int l) {

        int start = 0;
        int end = l - 1;

        int minIdx = 0;

        while (start <= end) {

            int mid = (start + end) / 2;
            int pre = (mid + l - 1) % l;
            int next = (mid + 1) % l;

            if (nums[pre] >= nums[mid] && nums[next] >= nums[mid]) {
                return mid;
            }
            if (nums[start] <= nums[end]) {
                return start;
            }
            if (nums[mid] >= nums[start]) {
                start = mid + 1;
            }
            if (nums[mid] <= nums[end]) {
                end = mid - 1;
            }

        }

        return 0;

    }

}
