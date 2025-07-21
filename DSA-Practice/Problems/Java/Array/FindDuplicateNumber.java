public class FindDuplicateNumber {
    class Solution {
        public int findDuplicate(int[] nums) {

            // start pointer at 0
            int slow = nums[0];
            int fast = nums[0];

            // Move slow by one and fast by two
            do {
                slow = nums[slow];
                fast = nums[nums[fast]];
            } while (slow != fast);

            fast = nums[0];

            while (slow != fast) {
                slow = nums[slow];
                fast = nums[fast];
            }

            return slow;
        }

        public int findDuplicate2(int[] nums) {
            Set<Integer> s = new HashSet();

            for (int i : nums) {
                if (s.contains(i))
                    return i;
                s.add(i);
            }
        }

        public int findDuplicate3(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                for (int j = i; j < nums.length; j++) {
                    if (i != j && nums[i] == nums[j])
                        return nums[i];
                }
            }

            return nums[0];

        }

    }
}
