public class RotatedSorted {
    public boolean check(int[] nums) {

        int breakCount = 0;

        for (int i = 0; i < nums.length; i++) {

            if(nums[i] > nums[(i + 1) % nums.length]) breakCount++;

            if(breakCount > 1) return false;
        }

        return true;

    }
}
