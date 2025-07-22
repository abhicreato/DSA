public class MaximumSumSubArray {
    class Solution {
        public int maxSubArray(int[] nums) {
            int max = nums[0];

            int sum = 0;
            for (int n : nums) {
                if (sum < 0) {
                    sum = 0;
                }
                sum = sum + n;
                max = Math.max(sum, max);
            }

            return max;
        }

        public int maxSubArray2(int[] nums) {
            int max = nums[0];
            int l = nums.length;

            for (int i = 0; i < l; i++) {
                int sum = 0;
                for (int j = i; j < l; j++) {
                    sum = sum + nums[j];
                    max = Math.max(max, sum);
                }
            }

            return max;
        }
    }
}
