public class Search2DArray {
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int col = matrix[0].length;
            int row = matrix.length;
            int start = 0;
            int end = (col * row) - 1;

            while (start <= end) {
                int mid = (start + end) / 2;
                //Logical flaten 2d->1d
                int rowId = mid / col;
                int colId = mid % col;
                int midVal = matrix[rowId][colId];

                if (midVal == target) {
                    return true;
                } else if (target > midVal) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            return false;
        }

        public boolean searchMatrix2(int[][] matrix, int target) {
            int rows = matrix.length;
            int cols = matrix[0].length;

            int top = 0;
            int bottom = rows - 1;

            // Binary search to find the correct row
            while (top <= bottom) {
                int midRow = top + (bottom - top) / 2;

                // Check if target is within the range of this row
                if (target >= matrix[midRow][0] && target <= matrix[midRow][cols - 1]) {
                    return binarySearch(matrix[midRow], target);
                } else if (target > matrix[midRow][cols - 1]) {
                    top = midRow + 1;
                } else {
                    bottom = midRow - 1;
                }
            }

            return false;
        }

        public boolean binarySearch(int[] nums, int t) {
            int start = 0;
            int end = nums.length - 1;

            while (start <= end) {
                int mid = (start + end) / 2;

                if (nums[mid] == t)
                    return true;

                if (nums[mid] > t) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            return false;
        }
    }
}
