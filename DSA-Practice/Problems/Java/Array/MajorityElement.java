import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    
    public static void main(String arg[]){

        int[]a = {1,2,3,2,2,2,3,4,5,2,2,2,4,5,6,6,4,2};
        System.out.println(majorityInt(a));
    }

    static int majorityInt(int[] ip){
        int candidate = 0;
        int vote =0;

        for(int n: ip){
            if(vote == 0){
                candidate = n;
                vote++;
            }else{
                if(candidate == n){
                    vote++;
                }else{
                    vote--;
                }
            }
        }
        return candidate;
    }

    public static int majorityInt2(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        System.out.println(map);
        return map.entrySet()
                .stream()
                .max(Comparator.comparing(Map.Entry::getValue)).get().getKey();

    }

    public static int majorityInt3(int[] nums, int k) {

        int number = 0;
        int count = 0;

        for (int n : nums) {
            if (count == 0) {
                number = n;
                count = 1;
            } else {
                count += (n == number) ? 1 : -1;
            }
        }

        return number;

    }
}
