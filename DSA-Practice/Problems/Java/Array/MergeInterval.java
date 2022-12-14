import java.util.*;
public class MergeInterval {

    public int[][] merge(int[][] intervals) {

        if(intervals.length == 0){
            return intervals;
        }

        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        List<int[]> output_arr = new ArrayList();
        int[] current_interval = intervals[0];
        output_arr.add(current_interval);

        for (int[] interval: intervals){
            int current_begin = current_interval[0];
            int current_end   = current_interval[1];
            int next_begin    = interval[0];
            int next_end      = interval[1];

            if (current_end >= next_begin){
                current_interval[1] = Math.max(next_end, current_end);

            }
            else{
                current_interval = interval;
                output_arr.add(current_interval);
            }
        }

        return output_arr.toArray(new int[output_arr.size()][]);
        
    }
    
}
