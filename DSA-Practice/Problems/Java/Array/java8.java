import java.util.*;
import java.util.stream.Collectors;

public class java8 {

    public static void main(String[] arg){

        // List<Integer> list = new ArrayList<>();
        // list.add(10);
        // list.add(48);
        // list.add(2);
        // list.add(4);


        // long corecount = Runtime.getRuntime().totalMemory(;

        // System.out.println(corecount);
        
        //list.stream().filter(i -> i > 1 ).forEach(System.out :: print);

        //list.stream().map(i -> i + 1 ).forEach(System.out :: print);

        //list.stream().sorted().forEach(System.out :: println);

        //System.out.println(list.stream().max((i,j) -> i.compareTo(j)).get());

        //System.out.println(list.stream().min((i,j) -> i.compareTo(j)).get());

        //list.stream().distinct().collect(Collectors.toList()).forEach(System.out :: println);

        int[] nums = {1,4,9,30,23,75,987,9856,0,1,-4,-5,-1};

        int one = Integer.MIN_VALUE;
        int two = Integer.MIN_VALUE;
        int three = Integer.MIN_VALUE;
        int four = Integer.MIN_VALUE;

        int[]top = new int[4];
        for(int i=0;i<nums.length;i++){
            int curr = nums[i];

            if(curr > one){
                four = three;
                three = two;
                two = one;
                one = curr;
            }else if(curr > two){
                four = three;
                three = two;
                two = curr;
            }else if(curr > three){
                four = three;
                three = curr;
            }else if(curr > four){
                four = curr;
            }

        }

        System.out.println(one);
        System.out.println(two);
        System.out.println(three);
        System.out.println(four);

    }
    
}
