import java.util.*;

public class MaximumOfAllSubarraysSizek {

    //Function to find maximum of each subarray of size k.
    public int[] maxSlidingWindow(int[] nums, int k) {

        int i = 0;
        int j = 0;
        int[] op = new int[nums.length - k + 1];
        Deque<Integer> max = new ArrayDeque<Integer>();

        while (j < nums.length) {

            while(!max.isEmpty() && max.peekLast() < nums[j]){
                max.removeLast();
            }

            max.add(nums[j]);

            if (j - i + 1 == k) {

                op[i] = max.peekFirst();

                if (max.peekFirst() == nums[i])
                    max.removeFirst();

                i++;
            }

            j++;
        }

        return op;

    }
    
}

