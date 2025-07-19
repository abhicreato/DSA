public class AllocateBooksStudentsK {

    // Back-end complete function Template for Java

    class Solution {
        public static int findPages(int[] arr, int k) {
            // code here
            int max = Integer.MIN_VALUE;
            int totalPages = 0;

            for (int n : arr) {
                totalPages += n;
                max = Math.max(max, n);
            }

            if (k > arr.length)
                return -1; // more students than books

            int start = max;
            int end = totalPages;
            int minPages = totalPages;

            while (start <= end) {
                int mid = (start + end) / 2;

                if (willCoverAllPages(arr, mid, k)) {
                    minPages = mid;
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }

            }

            return minPages;

        }

        public static boolean willCoverAllPages(int[] books, int maxPages, int numberOfStudents) {

            int alPages = 0;
            int alStudent = 1;

            for (int p : books) {
                if (p > maxPages)
                    return false; // single book more than mid
                if ((alPages + p) <= maxPages) {
                    alPages += p;
                } else {
                    alStudent++;
                    alPages = p;
                }

            }

            return (alStudent > numberOfStudents) ? false : true;
        }
    }

}
